package se.webinfostudio.game.etheder.api.resources.research;

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
import se.webinfostudio.game.etheder.api.model.research.ResearchQueueModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.research.ResearchQueueModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.research.ResearchQueueTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.service.research.ResearchQueueService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/researchQueue")
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class ResearchQueueResource extends AbstractResource {

	private final ResearchQueueService researchQueueService;
	private final ResearchQueueTransformer researchQueueTransformer;
	private final ResearchQueueModelTransformer researchQueueModelTransformer;

	@Inject
	ResearchQueueResource(final ObjectMapper objectMapper, final ResearchQueueService researchQueueService,
			final ResearchQueueTransformer researchQueueTransformer,
			final ResearchQueueModelTransformer researchQueueModelTransformer) {
		super(objectMapper);
		this.researchQueueService = researchQueueService;
		this.researchQueueTransformer = researchQueueTransformer;
		this.researchQueueModelTransformer = researchQueueModelTransformer;
	}

	/**
	 * Create a research quee for a city.
	 *
	 * @param researchId id of the research for the queue
	 * @param cityId     id of the city where the research will be done
	 * @param user       logged in user
	 * @return created {@link ResearchQueue}
	 */
	@POST
	@Timed
	public Response create(@Valid final ResearchQueueModel researchQueueModel, @Auth final AuthUser user) {
		return okFlat(researchQueueModelTransformer.apply(researchQueueService.createResearchQueue(
				researchQueueTransformer.apply(researchQueueModel), createUUIDFromString(user.getUserId()))));
	}

}
