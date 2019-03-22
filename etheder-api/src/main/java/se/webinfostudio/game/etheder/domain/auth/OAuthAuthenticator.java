package se.webinfostudio.game.etheder.domain.auth;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.fromString;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Optional;

import javax.persistence.NoResultException;

import org.slf4j.Logger;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.hibernate.UnitOfWork;
import se.webinfostudio.game.etheder.dao.user.UserDAO;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class OAuthAuthenticator implements Authenticator<String, AuthUser> {

	private static final Logger LOG = getLogger(OAuthAuthenticator.class);

	private final UserDAO userDAO;

	public OAuthAuthenticator(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@UnitOfWork
	@Override
	public Optional<AuthUser> authenticate(final String credentials) throws AuthenticationException {
		try {
			final Optional<User> user = userDAO.findByToken(fromString(credentials));
			if (user.isPresent()) {
				return of(AuthUser.newBuilder()
						.withFirstName(user.get().getFirstName())
						.withLastName(user.get().getLastName())
						.withUserName(user.get().getLogin().getUserName())
						.build());
			}
		} catch (final NoResultException e) {
			LOG.warn("Token: {} is not valid", credentials);
		}
		return empty();
	}

}
