package se.webinfostudio.game.etheder.api.resources.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createCityModel;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.player.CityModel;
import se.webinfostudio.game.etheder.api.resources.player.CityResource;
import se.webinfostudio.game.etheder.api.transformer.player.CityModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.player.CityTransformer;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.service.player.CityService;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityResourceTest {

	@InjectMocks
	private CityResource sut;

	@Mock
	private CityService cityService;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		final CityModelTransformer cityModelTransformer = new CityModelTransformer();
		final CityTransformer cityTransformer = new CityTransformer();

		sut = new CityResource(objectMapper, cityService, cityTransformer, cityModelTransformer);
	}

	@Test
	void create() {
		final CityModel cityModel = createCityModel();
		final City city = createCity();

		when(cityService.createCity(any(City.class))).thenReturn(city);

		final Response response = sut.create(cityModel);

		assertThat(response.getStatus()).isEqualTo(200);
	}
}
