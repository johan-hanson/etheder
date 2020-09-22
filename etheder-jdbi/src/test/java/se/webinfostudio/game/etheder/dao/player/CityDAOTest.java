package se.webinfostudio.game.etheder.dao.player;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class CityDAOTest {

	private CityDAO sut;

	@BeforeEach
	void before() {
		sut = new CityDAO();
	}

	void findById() {
		final City city = createCity();
		sut.persist(city);

		final Optional<City> result = sut.findById(city.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(city.getId());
	}

	void persist() {
		final City city = createCity();
		final City result = sut.persist(city);

		assertThat(result.getId()).isEqualTo(city.getId());
	}

}
