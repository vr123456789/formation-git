package fr.insee.bar.repository;

import org.springframework.data.jpa.domain.Specification;

import fr.insee.bar.model.Cocktail;
import fr.insee.bar.search.Search;

public abstract class CocktailSpec {

	public static Specification<Cocktail> search(String search) {
		String q = "%" + Search.normalize(search) + "%";
		return (cocktail, query, builder) -> builder.like(cocktail.get("nomNorm"), q);
	}
}
