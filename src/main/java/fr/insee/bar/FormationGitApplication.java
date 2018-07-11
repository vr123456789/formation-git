package fr.insee.bar;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
public class FormationGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormationGitApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase database = builder
			.setType(EmbeddedDatabaseType.HSQL)
			.addScript("db/create-db.sql")
			.addScript("db/insert-data.sql")
			.build();
		return database;
	}
}
