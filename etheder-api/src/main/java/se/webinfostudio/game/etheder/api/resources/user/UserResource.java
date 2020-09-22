package se.webinfostudio.game.etheder.api.resources.user;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static org.slf4j.LoggerFactory.getLogger;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.auth.Auth;
import se.webinfostudio.game.etheder.api.model.user.UserChangePasswordModel;
import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.user.LoginUserTransformer;
import se.webinfostudio.game.etheder.api.transformer.user.UserModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.user.UserTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.service.user.UserService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends AbstractResource {

	private static final Logger LOGGER = getLogger(UserResource.class);

	private final UserService userService;
	private final UserTransformer userTransformer;
	private final UserModelTransformer userModelTransformer;
	private final LoginUserTransformer loginUserTransformer;

	@Inject
	UserResource(
			final ObjectMapper objectMapper,
			final UserService userService,
			final UserTransformer userTransformer,
			final UserModelTransformer userModelTransformer,
			final LoginUserTransformer loginUserTransformer) {
		super(objectMapper);
		this.userService = userService;
		this.userTransformer = userTransformer;
		this.userModelTransformer = userModelTransformer;
		this.loginUserTransformer = loginUserTransformer;
	}

	/**
	 * TODO: change to object. Just added annotation so the resource is valid.
	 *
	 * @param newPassword
	 * @return {@link Response}
	 */
	@PUT
	@Timed
	@PermitAll
	@Path("/change")
	public Response changePassword(@Valid final UserChangePasswordModel userChangePasswordModel,
			@Auth final AuthUser authUser) {
		userService.updatePassword(authUser.getUserName(), userChangePasswordModel.getOldPassword(),
				userChangePasswordModel.getNewPassword());
		return Response.ok().build();
	}

	@POST
	@Timed
	public Response create(@Valid final UserModel userModel) {
		LOGGER.info("create user");
		try {
			return okFlat(userModelTransformer
					.apply(userService.createUser(
							loginUserTransformer.apply(userModel),
							userTransformer.apply(userModel))));
		} catch (final Exception e) {
			// TODO: remove this with exception mapper
			LOGGER.error("Error creating user", e);
		}
		return Response.status(BAD_REQUEST).build();
	}

	@PUT
	@Timed
	@PermitAll
	public Response update(@Valid final UserModel userModel) {
		return okFlat(userModelTransformer.apply(userService.updateUser(userTransformer.apply(userModel))));
	}
}
