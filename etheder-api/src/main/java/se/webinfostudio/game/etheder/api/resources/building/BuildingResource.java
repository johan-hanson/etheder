package se.webinfostudio.game.etheder.api.resources.building;

import static org.slf4j.LoggerFactory.getLogger;
import static se.webinfostudio.game.etheder.api.transformer.TransformerHelper.createUUIDFromString;

import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueModelTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
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
	private final BuildingQueueModelTransformer buildingQueueModelTransformer;

	@Inject
	BuildingResource(final ObjectMapper objectMapper, final BuildingService buildingService,
			final BuildingModelTransformer buildingModelTransformer,
			final BuildingQueueModelTransformer buildingQueueModelTransformer) {
		super(objectMapper);
		this.buildingService = buildingService;
		this.buildingModelTransformer = buildingModelTransformer;
		this.buildingQueueModelTransformer = buildingQueueModelTransformer;
	}

	/**
	 * Creates a building for a city.
	 *
	 * @param buildingDataId id of the building to create
	 * @param cityId         id of the city where the building will be created
	 * @param user           logged in user
	 * @return created {@link BuildingQueue}
	 */
	@POST
	@Timed
	@UnitOfWork
	public Response create(final Long buildingDataId, final String cityId, @Auth final AuthUser user) {
		LOG.info("create");
		return okFlat(buildingQueueModelTransformer.apply(buildingService.createBuilding(buildingDataId,
				createUUIDFromString(cityId), createUUIDFromString(user.getUserId()))));
	}

	@GET
	@Path("/{id}")
	@Timed
	@UnitOfWork
	public Response getBuilding(@PathParam("id") final String id) {
		LOG.info("findBuilding, id: {}", id);
		// Validate input
		final Optional<Building> building = buildingService.findById(id);

		if (building.isPresent()) {
			return okFlat(buildingModelTransformer.apply(building.get()));
		}
		return notFound("Building not found");
	}

	@GET
	@Timed
	@UnitOfWork
	public Response listAll() {
		LOG.info("List all buildings");
		return buildingService.findAll().stream().map(building -> buildingModelTransformer.apply(building))
				.collect(okFlat("buildings"));
	}
}
