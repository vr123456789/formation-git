package fr.insee.bar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.insee.bar.model.Client;

public interface ClientRepository extends JpaRepository<Client, Short>, JpaSpecificationExecutor<Client> {

	public Optional<Client> findByEmail(String email);
}
