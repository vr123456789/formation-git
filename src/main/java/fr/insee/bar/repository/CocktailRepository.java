package fr.insee.bar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import fr.insee.bar.model.Cocktail;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Short>, JpaSpecificationExecutor<Cocktail> {
}
