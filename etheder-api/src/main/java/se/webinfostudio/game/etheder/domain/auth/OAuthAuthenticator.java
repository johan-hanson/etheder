package se.webinfostudio.game.etheder.domain.auth;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.fromString;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Optional;

import org.slf4j.Logger;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.repository.user.LoginRepository;
import se.webinfostudio.game.etheder.repository.user.UserRepository;

/**
 *
 * @author Johan Hanson
 *
 */
public class OAuthAuthenticator implements Authenticator<String, AuthUser> {

	private static final Logger LOG = getLogger(OAuthAuthenticator.class);

	private final LoginRepository loginRepository;

	private final UserRepository userRepository;

	public OAuthAuthenticator(final LoginRepository loginRepository, final UserRepository userRepository) {
		this.loginRepository = loginRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Optional<AuthUser> authenticate(final String credentials) throws AuthenticationException {
		try {
			final Optional<Login> login = loginRepository.findByToken(fromString(credentials));
			if (login.isPresent()) {
				final User user = userRepository.findByLoginId(login.get().getId());
				return of(AuthUser.newBuilder()
						.withFirstName(user.getFirstName())
						.withLastName(user.getLastName())
						.withUserName(login.get().getUserName())
						.withUserId(user.getId().toString())
						.build());
			}
		} catch (final Exception e) {
			LOG.debug("Token: {} is not valid", credentials);
			throw new AuthenticationException("User not logged in");
		}
		return empty();
	}

}
