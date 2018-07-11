package fr.insee.bar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import fr.insee.bar.model.Cocktail;

@Component
public class CocktailRowMapper implements RowMapper<Cocktail> {

	@Override
	public Cocktail mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cocktail cocktail = new Cocktail();
		cocktail.setId(rs.getShort("id"));
		cocktail.setNom(rs.getString("nom"));
		cocktail.setPrix(rs.getDouble("prix"));
		return cocktail;
	}

}
