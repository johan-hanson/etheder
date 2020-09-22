package se.webinfostudio.game.etheder.domain.auth;

import com.google.inject.Provides;
import com.google.inject.Singleton;

import io.dropwizard.auth.CachingAuthenticator;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import se.webinfostudio.game.etheder.ApiConfiguration;
import se.webinfostudio.game.etheder.repository.user.LoginRepository;
import se.webinfostudio.game.etheder.repository.user.UserRepository;

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
	protected OAuthAuthenticator providesAuthenticator(
			final LoginRepository loginRepository,
			final UserRepository userRepository) {
		return new OAuthAuthenticator(loginRepository, userRepository);
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
