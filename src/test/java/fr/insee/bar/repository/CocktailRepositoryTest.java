package fr.insee.bar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import fr.insee.bar.beans.Cocktail;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("serveur")
public class CocktailRepositoryTest {

	@Autowired
	private CocktailRepository cocktailRepository;

	@Test
	public void whenCount_returnSize() {
		assertThat(cocktailRepository.count()).isEqualTo(98L);
	}

	@Test
	public void whenFindAll_returnAll() {
		assertThat(cocktailRepository.findAll()).hasSize(98);
	}

	@Test
	public void whenFindById_returnOne() {
		assertThat(cocktailRepository.findById((short) 150)).isPresent();
	}

	@Test
	public void whenFindById_returnEmpty() {
		assertThat(cocktailRepository.findById((short) 0)).isEmpty();
	}

	@Test
	public void whenSearchRUS_returnMatches() {
		assertThat(cocktailRepository.findAll(CocktailSpec.search("RUS"))).allMatch(c -> c.getNom().toUpperCase().contains("RUS"));
	}

	@Test
	public void whenSearchByExample_returnFullCopy() {
		Cocktail example = new Cocktail();
		example.setId((short) 150);
		assertThat(cocktailRepository.findByExample(example)).hasFieldOrPropertyWithValue("prix", 8.0);
	}
}
