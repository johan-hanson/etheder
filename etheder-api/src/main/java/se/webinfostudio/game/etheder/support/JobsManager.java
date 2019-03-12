package se.webinfostudio.game.etheder.support;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.inject.Injector;

import de.spinscale.dropwizard.jobs.GuiceJobManager;
import se.webinfostudio.game.etheder.ApiConfiguration;

/**
 * Bean will be recognized as Managed and installed automatically. Used as a
 * replacement for {@link de.spinscale.dropwizard.jobs.GuiceJobsBundle}.
 *
 * @author Johan Hanson
 *
 */
@Singleton
public class JobsManager extends GuiceJobManager {

	@Inject
	public JobsManager(final Injector injector, final ApiConfiguration configuration) {
		super(injector);
		configure(configuration);
	}
}
