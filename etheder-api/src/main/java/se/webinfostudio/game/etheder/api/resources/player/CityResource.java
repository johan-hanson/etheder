package se.webinfostudio.game.etheder.api.resources.player;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.player.CityModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.player.CityModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.player.CityTransformer;
import se.webinfostudio.game.etheder.service.player.CityService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/city")
@Produces(MediaType.APPLICATION_JSON)
public class CityResource extends AbstractResource {

	private final CityService cityService;
	private final CityTransformer cityTransformer;
	private final CityModelTransformer cityModelTransformer;

	@Inject
	CityResource(final ObjectMapper objectMapper, final CityService cityService, final CityTransformer cityTransformer,
			final CityModelTransformer cityModelTransformer) {
		super(objectMapper);
		this.cityService = cityService;
		this.cityTransformer = cityTransformer;
		this.cityModelTransformer = cityModelTransformer;
	}

	@POST
	@Timed
	public Response create(@Valid final CityModel cityModel) {
		return okFlat(cityModelTransformer.apply(cityService.createCity(cityTransformer.apply(cityModel))));
	}

}
