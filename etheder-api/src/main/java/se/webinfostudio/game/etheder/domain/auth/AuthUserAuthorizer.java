package se.webinfostudio.game.etheder.domain.auth;

import io.dropwizard.auth.Authorizer;

/**
 *
 * @author Johan Hanson
 *
 */
public class AuthUserAuthorizer implements Authorizer<AuthUser> {

	@Override
	public boolean authorize(final AuthUser principal, final String role) {
		return principal.hasRole(role);
	}

}
