package se.webinfostudio.game.etheder.base;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import se.webinfostudio.game.etheder.ApiConfiguration;

public class BaseModule extends DropwizardAwareModule<ApiConfiguration> {

	/**
	 * Returns a new instance of {@code BaseModule}.
	 *
	 * @return a new instance of {@code BaseModule}.
	 */
	public static BaseModule baseModule() {
		return new BaseModule();
	}

	private BaseModule() {
	}

	/**
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
	}

	@Provides
	@Singleton
	protected ObjectMapper providesObjectMapper() {
		return environment().getObjectMapper().setSerializationInclusion(NON_NULL);
	}

}
