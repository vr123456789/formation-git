package fr.insee.bar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import fr.insee.bar.model.Client;
import fr.insee.bar.model.Client.Titre;

@Component
public class ClientRowMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setId(rs.getShort("id"));
		client.setNom(rs.getString("nom"));
		client.setEmail(rs.getString("email"));
		client.setDateNaissance(rs.getDate("date_naissance"));
		client.setTitre(Titre.of(rs.getShort("titre")));
		return client;
	}

}
