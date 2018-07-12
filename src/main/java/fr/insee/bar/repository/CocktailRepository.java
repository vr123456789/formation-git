package fr.insee.bar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.insee.bar.model.Cocktail;

public interface CocktailRepository extends JpaRepository<Cocktail, Short>, JpaSpecificationExecutor<Cocktail> {

	@Query("select c from Cocktail c where c.id = :#{#cocktail.id}")
	public Cocktail findByExample(@Param("cocktail") Cocktail cocktail);

	@Query("select c from Cocktail c where c.nomNorm like('%:search%')")
	public List<Cocktail> search(String search);
}
