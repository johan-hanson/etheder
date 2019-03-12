package se.webinfostudio.game.etheder.api.resources.player;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.hibernate.UnitOfWork;
import se.webinfostudio.game.etheder.api.model.player.PlayerModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.player.PlayerModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.player.PlayerTransformer;
import se.webinfostudio.game.etheder.service.player.PlayerService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource extends AbstractResource {

	private final PlayerService playerService;
	private final PlayerTransformer playerTransformer;
	private final PlayerModelTransformer playerModelTransformer;

	@Inject
	PlayerResource(final ObjectMapper objectMapper, final PlayerService playerService,
			final PlayerTransformer playerTransformer, final PlayerModelTransformer playerModelTransformer) {
		super(objectMapper);
		this.playerService = playerService;
		this.playerTransformer = playerTransformer;
		this.playerModelTransformer = playerModelTransformer;
	}

	@POST
	@Timed
	@UnitOfWork
	public Response createPlayer(@Valid final PlayerModel playerModel) {
		return okFlat(
				playerModelTransformer.apply(playerService.createPlayer(playerTransformer.apply(playerModel))));
	}

	@PUT
	@Timed
	@UnitOfWork
	public Response updatePlayer(@Valid final PlayerModel playerModel) {
		return okFlat(
				playerModelTransformer.apply(playerService.updatePlayer(playerTransformer.apply(playerModel))));
	}
}
