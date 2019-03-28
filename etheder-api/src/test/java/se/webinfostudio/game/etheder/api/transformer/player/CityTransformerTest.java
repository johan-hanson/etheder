package se.webinfostudio.game.etheder.api.transformer.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createCityModel;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createCityModelNew;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.player.CityModel;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityTransformerTest {

	@InjectMocks
	private CityTransformer sut;

	@Test
	void apply() {
		final CityModel cityModel = createCityModel();
		final City result = sut.apply(cityModel);

		assertThat(result.getId().toString()).isEqualTo(cityModel.getCityId());
		assertThat(result.getName()).isEqualTo(cityModel.getName());
		assertThat(result.getPlayer().getId().toString()).isEqualTo(cityModel.getPlayerId());
	}

	@Test
	void apply_withNoId() {
		final CityModel cityModel = createCityModelNew();
		final City result = sut.apply(cityModel);

		assertThat(result.getId()).isNull();
		assertThat(result.getName()).isEqualTo(cityModel.getName());
		assertThat(result.getPlayer().getId().toString()).isEqualTo(cityModel.getPlayerId());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}

}
