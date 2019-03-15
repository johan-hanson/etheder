package se.webinfostudio.game.etheder.api.resources.player;

import java.util.Optional;

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
import se.webinfostudio.game.etheder.api.model.user.LoginModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.user.LoginTransformer;
import se.webinfostudio.game.etheder.api.transformer.user.UserTokenModelTransformer;
import se.webinfostudio.game.etheder.entity.player.Login;
import se.webinfostudio.game.etheder.service.player.LoginService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource extends AbstractResource {

	private final LoginService loginService;
	private final LoginTransformer loginTransformer;
	private final UserTokenModelTransformer userTokenModelTransformer;

	@Inject
	LoginResource(final ObjectMapper objectMapper, final LoginService loginService,
			final LoginTransformer loginTransformer, final UserTokenModelTransformer userTokenModelTransformer) {
		super(objectMapper);
		this.loginService = loginService;
		this.loginTransformer = loginTransformer;
		this.userTokenModelTransformer = userTokenModelTransformer;
	}

	@POST
	@Timed
	@UnitOfWork
	public Response login(@Valid final LoginModel loginModel) {
		final Optional<Login> login = loginService.login(loginTransformer.apply(loginModel));
		if (login.isPresent()) {
			return okFlat(userTokenModelTransformer.apply(login.get()));
		}
		// Todo throw a better exception
		throw new RuntimeException("Login failed");
	}
}
