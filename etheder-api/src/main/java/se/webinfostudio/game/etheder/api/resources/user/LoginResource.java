package se.webinfostudio.game.etheder.api.resources.user;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.user.LoginModel;
import se.webinfostudio.game.etheder.api.resources.AbstractResource;
import se.webinfostudio.game.etheder.api.transformer.user.LoginTransformer;
import se.webinfostudio.game.etheder.api.transformer.user.UserTokenModelTransformer;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.service.user.LoginService;

/**
 *
 * @author Johan Hanson
 *
 */
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource extends AbstractResource {

	private static final Logger LOG = getLogger(LoginResource.class);

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
	public Response login(@Valid final LoginModel loginModel) {
		LOG.info("Run login");
		final Optional<Login> login = loginService.login(loginTransformer.apply(loginModel));
		if (login.isPresent()) {
			return okFlat(userTokenModelTransformer.apply(login.get()));
		}
		// Todo throw a better exception
		throw new RuntimeException("Login failed");
	}
}
