package se.webinfostudio.game.etheder.api.resources.building;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.auth.Auth;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingModelTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.service.building.BuildingService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/building")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class BuildingResource extends AbstractResource {

	private static final Logger LOG = getLogger(BuildingResource.class);

	private final BuildingService buildingService;
	private final BuildingModelTransformer buildingModelTransformer;

	@Inject
	BuildingResource(final ObjectMapper objectMapper, final BuildingService buildingService,
			final BuildingModelTransformer buildingModelTransformer) {
		super(objectMapper);
		this.buildingService = buildingService;
		this.buildingModelTransformer = buildingModelTransformer;
	}

	@GET
	@Path("/{id}")
	@Timed
	public Response getBuilding(@PathParam("id") final String id) {
		LOG.info("findBuilding, id: {}", id);
		// Validate input
		final Optional<Building> building = buildingService.findById(id);

		if (building.isPresent()) {
			return okFlat(buildingModelTransformer.apply(building.get()));
		}
		return notFound("Building not found");
	}

	/**
	 * Lists all buildings in a {@link City}.
	 *
	 * @return a list of {@link Building}s
	 */
	@GET
	@Timed
	@Path("/list/{city}")
	public Response listAll(@PathParam("cityId") final String cityId, @Auth final AuthUser user) {
		LOG.info("List all buildings");
		return buildingService.findAll().stream().map(building -> buildingModelTransformer.apply(building))
				.collect(okFlat("buildings"));
	}
}
