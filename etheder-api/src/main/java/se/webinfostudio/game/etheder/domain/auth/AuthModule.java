package se.webinfostudio.game.etheder.domain.auth;

import com.google.inject.Provides;
import com.google.inject.Singleton;

import io.dropwizard.auth.CachingAuthenticator;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import se.webinfostudio.game.etheder.ApiConfiguration;
import se.webinfostudio.game.etheder.dao.user.UserDAO;

/**
 *
 * @author Johan Hanson
 *
 */
public class AuthModule extends DropwizardAwareModule<ApiConfiguration> {

	public static AuthModule authModule() {
		return new AuthModule();
	}

	private AuthModule() {
		// Hidden
	}

	@Provides
	@Singleton
	protected OAuthAuthenticator providesAuthenticator(final HibernateBundle<ApiConfiguration> hibernateBundle) {
		final UserDAO dao = new UserDAO(hibernateBundle.getSessionFactory());
		return new UnitOfWorkAwareProxyFactory(hibernateBundle)
				.create(OAuthAuthenticator.class, UserDAO.class, dao);
	}

	@Provides
	@Singleton
	protected CachingAuthenticator<String, AuthUser> providesCachingAuthenticator(
			final ApiConfiguration configuration,
			final OAuthAuthenticator authenticator) {
		return new CachingAuthenticator<>(environment().metrics(), authenticator,
				configuration.getAuthCacheConfiguration());
	}
}
