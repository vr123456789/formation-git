package fr.insee.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.insee.bar.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Short>, JpaSpecificationExecutor<Employe> {
}
