package se.webinfostudio.game.etheder.domain.auth;

import java.util.Optional;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import se.webinfostudio.game.etheder.dao.player.UserDAO;

/**
 *
 * @author Johan Hanson
 *
 */
public class OAuthAuthenticator implements Authenticator<String, AuthUser> {

	private final UserDAO userDAO;

	public OAuthAuthenticator(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public Optional<AuthUser> authenticate(final String credentials) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

}
