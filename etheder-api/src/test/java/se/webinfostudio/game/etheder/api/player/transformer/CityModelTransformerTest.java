package se.webinfostudio.game.etheder.api.player.transformer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.player.CityModel;
import se.webinfostudio.game.etheder.api.transformer.player.CityModelTransformer;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityModelTransformerTest {

	@InjectMocks
	private CityModelTransformer sut;

	@Test
	void apply() {
		final City city = createCity();
		final CityModel result = sut.apply(city);

		assertThat(result.getCityId()).isEqualTo(city.getId().toString());
		assertThat(result.getName()).isEqualTo(city.getName());
		assertThat(result.getPlayerId()).isEqualTo(city.getPlayer().getId().toString());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}

}
