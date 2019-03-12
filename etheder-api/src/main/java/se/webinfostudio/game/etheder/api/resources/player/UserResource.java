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
import se.webinfostudio.game.etheder.api.model.player.UserModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.player.UserModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.player.UserTransformer;
import se.webinfostudio.game.etheder.service.player.UserService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends AbstractResource {

	private final UserService userService;
	private final UserTransformer userTransformer;
	private final UserModelTransformer userModelTransformer;

	@Inject
	UserResource(final ObjectMapper objectMapper, final UserService userService, final UserTransformer userTransformer,
			final UserModelTransformer userModelTransformer) {
		super(objectMapper);
		this.userService = userService;
		this.userTransformer = userTransformer;
		this.userModelTransformer = userModelTransformer;
	}

	/**
	 * TODO: change to object.
	 *
	 * @param oldPassword
	 * @param newPassword
	 * @return {@link Response}
	 */
	@PUT
	@Timed
	@UnitOfWork
	public Response changePassword(final String oldPassword, final String newPassword) {
		userService.updatePassword(oldPassword, newPassword);
		return Response.ok().build();
	}

	@POST
	@Timed
	@UnitOfWork
	public Response create(@Valid final UserModel userModel) {
		return okFlat(userModelTransformer.apply(userService.createUser(userTransformer.apply(userModel))));
	}

	@PUT
	@Timed
	@UnitOfWork
	public Response update(@Valid final UserModel userModel) {
		return okFlat(userModelTransformer.apply(userService.updateUser(userTransformer.apply(userModel))));
	}
}
