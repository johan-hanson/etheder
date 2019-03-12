package se.webinfostudio.game.etheder.api.resources.building;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.hibernate.UnitOfWork;
import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueTransformer;
import se.webinfostudio.game.etheder.service.building.BuildingQueueService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/buildingQueue")
@Produces(MediaType.APPLICATION_JSON)
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

	@POST
	@Timed
	@UnitOfWork
	public Response create(@Valid final BuildingQueueModel buildingQueueModel) {
		return okFlat(buildingQueueModelTransformer
				.apply(buildingQueueService.createBuildingQueue(buildingQueueTransformer.apply(buildingQueueModel))));
	}
}
