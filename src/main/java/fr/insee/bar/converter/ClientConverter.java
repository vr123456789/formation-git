package fr.insee.bar.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.insee.bar.model.Client;
import fr.insee.bar.repository.ClientRepository;

@Component
public class ClientConverter implements Converter<String, Client> {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client convert(String id) {
		Optional<Client> client = clientRepository.findById(Short.valueOf(id));
		return client.orElse(Client.EMPTY);
	}
}
