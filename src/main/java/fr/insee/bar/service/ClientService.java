package fr.insee.bar.service;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Objects;

import fr.insee.bar.beans.Client;
import fr.insee.bar.beans.Client.Titre;
import fr.insee.bar.exception.BarClientException;
import fr.insee.bar.repository.ClientRepository;


@Service
public class ClientService {

	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository clientRepository;

	public boolean emailDejaUtilise(Client client) {
		Optional<Client> optional = clientRepository.findByEmail(client.getEmail());
		if (optional.isPresent()) {
			Client autre = optional.get();
			return !Objects.equal(autre.getId(), client.getId());
		}
		return false;
	}

	private boolean emailDejaUtiliseFast(String email) {
		Optional<Client> optional = clientRepository.findByEmail(email);
		return optional.isPresent();
	}

	public long chargement(MultipartFile multipartFile) {
		File file = new File("clients.txt");
		try {
			multipartFile.transferTo(file);
			return FileUtils
				.readLines(file, "UTF-8")
				.stream()
				.map(this::client)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(clientRepository::save)
				.count();
		}
		catch (IOException e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

	public File fichier() {
		File file = new File("clients.txt");
		try {
			FileUtils.writeLines(file, "UTF-8", clientRepository
				.findAll()
				.stream()
				.map(this::string)
				.collect(Collectors.toList()));
		}
		catch (IOException e) {
			logger.error(e.getMessage());
		}
		return file;
	}

	private String string(Client client) {
		StringBuilder builder = new StringBuilder();
		builder
			.append(client.getTitre().getCode())
			.append(";")
			.append(client.getNom())
			.append(";")
			.append(client.getEmail())
			.append(";")
			.append(this.string(client.getDateNaissance()))

		;
		return builder.toString();
	}

	private String string(Date date) {
		return DateTimeFormatter
			.ofPattern("dd/MM/yyyy")
			.format(Instant
				.ofEpochMilli(date.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate());
	}

	private Optional<Client> client(String ligne) {
		try {
			return this.clientException(ligne);
		}
		catch (BarClientException e) {
			logger.error(e.getMessage());
		}
		return Optional.empty();
	}

	private Client client(String[] tokens) throws BarClientException, NumberFormatException, DateTimeParseException {
		if (tokens.length != 4) {
			throw new BarClientException(String.format("Il y a %d éléments au lieu de 4.", tokens.length));
		}
		if (this.emailDejaUtiliseFast(tokens[2])) {
			throw new BarClientException(String.format("L’email %s est déjà utilisé.", tokens[2]));
		}
		Client client = new Client();
		client.setTitre(Titre.of(Short.valueOf(tokens[0])));
		client.setNom(tokens[1]);
		client.setEmail(tokens[2]);
		client.setDateNaissance(this.date(tokens[3]));
		return client;
	}

	private Date date(String string) throws DateTimeParseException {
		Instant instant = LocalDate
			.parse(string, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			.atStartOfDay()
			.atZone(ZoneId.systemDefault())
			.toInstant();
		return Date.from(instant);

	}

	public List<Client> clients() {
		return clientRepository.findAll();
	}

	private Optional<Client> clientException(String ligne) throws BarClientException {
		if (StringUtils.isNotBlank(ligne)) {
			String[] tokens = ligne.split(";");
			try {
				return Optional.of(this.client(tokens));
			}
			catch (NumberFormatException e) {
				throw new BarClientException(String.format("La ligne [%s] est invalide. %s n’est pas un nombre valide.", ligne, tokens[0]));
			}
			catch (DateTimeParseException e) {
				throw new BarClientException(String.format("La ligne [%s] est invalide. La date %s n’est pas au format dd/mm/yyyy", ligne, tokens[3]));
			}
			catch (BarClientException e) {
				throw new BarClientException(String.format("La ligne [%s] est invalide. %s", ligne, e.getMessage()));
			}
		}
		return Optional.empty();
	}
}
