package se.webinfostudio.game.etheder.api.resources.building;

import static se.webinfostudio.game.etheder.api.transformer.TransformerHelper.createUUIDFromString;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;
import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.service.building.BuildingQueueService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/buildingQueue")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class BuildingQueueResource extends AbstractResource {

	private final BuildingQueueService buildingQueueService;
	private final BuildingQueueTransformer buildingQueueTransformer;
	private final BuildingQueueModelTransformer buildingQueueModelTransformer;

	@Inject
	BuildingQueueResource(final ObjectMapper objectMapper, final BuildingQueueService buildingQueueService,
			final BuildingQueueTransformer buildingQueueTransformer,
			final BuildingQueueModelTransformer buildingQueueModelTransformer) {
		super(objectMapper);
		this.buildingQueueService = buildingQueueService;
		this.buildingQueueTransformer = buildingQueueTransformer;
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
	public Response create(@Valid final BuildingQueueModel buildingQueueModel, @Auth final AuthUser user) {
		return okFlat(buildingQueueModelTransformer.apply(buildingQueueService.createBuildingQueue(
				buildingQueueTransformer.apply(buildingQueueModel), createUUIDFromString(user.getUserId()))));
	}
}
