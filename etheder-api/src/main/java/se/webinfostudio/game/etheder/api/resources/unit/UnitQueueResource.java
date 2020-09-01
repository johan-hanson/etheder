package se.webinfostudio.game.etheder.api.resources.unit;

import static se.webinfostudio.game.etheder.api.transformer.TransformerHelper.createUUIDFromString;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.auth.Auth;
import se.webinfostudio.game.etheder.api.model.unit.UnitQueueModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.unit.UnitQueueModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.unit.UnitQueueTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.service.unit.UnitQueueService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/unitQueue")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class UnitQueueResource extends AbstractResource {

	private final UnitQueueService unitQueueService;
	private final UnitQueueTransformer unitQueueTransformer;
	private final UnitQueueModelTransformer unitQueueModelTransformer;

	@Inject
	UnitQueueResource(final ObjectMapper objectMapper, final UnitQueueService unitQueueService,
			final UnitQueueTransformer unitQueueTransformer,
			final UnitQueueModelTransformer unitQueueModelTransformer) {
		super(objectMapper);
		this.unitQueueService = unitQueueService;
		this.unitQueueTransformer = unitQueueTransformer;
		this.unitQueueModelTransformer = unitQueueModelTransformer;
	}

	@POST
	@Timed
	public Response create(@Valid final UnitQueueModel unitQueueModel, @Auth final AuthUser user) {
		return okFlat(unitQueueModelTransformer
				.apply(unitQueueService.createUnitQueue(unitQueueTransformer.apply(unitQueueModel),
						createUUIDFromString(user.getUserId()))));
	}

	@GET
	@Timed
	@Path("/list/{cityId}")
	public Response listQueues(@PathParam("cityId") final String cityId, @Auth final AuthUser user) {
		return okFlat(unitQueueModelTransformer
				.apply(unitQueueService.listUnitQueues(cityId, user.getUserId())));
	}
}
