package fr.insee.bar.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import fr.insee.bar.model.Cocktail;
import fr.insee.bar.search.Search;

public abstract class CocktailSpec {

	public static Specification<Cocktail> search(String search) {
		String q = "%" + Search.normalize(search) + "%";
		return (Root<Cocktail> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.like(root.get("nomNorm"), q);
	}
}
