package fr.insee.bar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.insee.bar.exception.BarCommandeException;
import fr.insee.bar.model.Cocktail;
import fr.insee.bar.repository.CocktailRepository;
import fr.insee.bar.repository.CocktailSpec;
import fr.insee.bar.service.CocktailService;

@Controller
@RequestMapping("/cocktails")
public class CocktailsController {

	@Autowired
	private CocktailRepository cocktailRepository;

	@Autowired
	private CocktailService cocktailService;

	@GetMapping("/recherche")
	@ResponseBody
	public List<Cocktail> recherche(@RequestParam("q") String q) {
		return cocktailRepository.findAll(CocktailSpec.search(q));
	}

	@PostMapping("/commande")
	@ResponseBody
	public Double commande(@RequestBody List<Cocktail> cocktails) throws BarCommandeException {
		cocktailService.verifierCommandeValide(cocktails);
		double prix = cocktails.stream()
			.map(cocktailRepository::findByExample)
			.mapToDouble(Cocktail::getPrix)
			.sum();
		return prix;
	}
}
