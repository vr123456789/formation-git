package fr.insee.bar.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import fr.insee.bar.model.Employe;
import fr.insee.bar.model.Role;

@Component
public class EmployeRowMapper implements RowMapper<Employe> {

	@Override
	public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
		Role role = new Role();
		role.setId(rs.getShort("rid"));
		role.setLibelle(rs.getString("libelle"));
		Employe salarie = new Employe();
		salarie.setId(rs.getShort("eid"));
		salarie.setNom(rs.getString("nom"));
		salarie.setRole(role);
		return salarie;
	}
}
