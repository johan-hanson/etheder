package se.webinfostudio.game.etheder.domain.auth;

import javax.inject.Inject;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Environment;

/**
 *
 * @author Johan Hanson
 *
 */
@Provider
public class OAuthDynamicFeature extends AuthDynamicFeature {

	@Inject
	public OAuthDynamicFeature(
			final OAuthAuthenticator authenticator,
			final AuthUserAuthorizer authorizer,
			final Environment environment) {
		super(new OAuthCredentialAuthFilter.Builder<AuthUser>()
				.setAuthenticator(authenticator)
				.setAuthorizer(authorizer)
				.setPrefix("Bearer")
				.buildAuthFilter());

		environment.jersey().register(RolesAllowedDynamicFeature.class);
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));
	}
}
