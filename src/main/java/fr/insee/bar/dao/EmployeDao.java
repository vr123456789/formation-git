package fr.insee.bar.dao;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableMap;

import fr.insee.bar.model.Employe;

@Repository
public class EmployeDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EmployeRowMapper rowMapper;

	private NamedParameterJdbcTemplate template;

	private static final String SQL_FIND =
		"select e.id as eid, e.nom as nom, r.id as rid, r.libelle as libelle "
			+ "from employes e "
			+ "left join roles r "
			+ "on e.idrole = r.id "
			+ "where e.id = :id";
	private static final String SQL_FIND_ALL =
		"select e.id as eid, e.nom as nom, r.id as rid, r.libelle as libelle "
			+ "from employes e "
			+ "left join roles r "
			+ "on e.idrole = r.id";

	@PostConstruct
	private void postConstruct() {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	public Optional<Employe> find(Short id) {
		try {
			Employe salarie = template.queryForObject(SQL_FIND, ImmutableMap.of("id", id), rowMapper);
			return Optional.of(salarie);

		}
		catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	public List<Employe> findAll() {
		return template.query(SQL_FIND_ALL, rowMapper);
	}
}
