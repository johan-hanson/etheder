package se.webinfostudio.game.etheder.support;

import de.spinscale.dropwizard.jobs.Job;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.module.installer.FeatureInstaller;
import ru.vyarus.dropwizard.guice.module.installer.install.TypeInstaller;
import ru.vyarus.dropwizard.guice.module.installer.util.FeatureUtils;
import ru.vyarus.dropwizard.guice.module.installer.util.Reporter;

/**
 * Copied from example by xvik.
 *
 * @see https://github.com/xvik/dropwizard-guicey-examples/tree/master/dropwizard-jobs
 * @author Johan Hanson
 *
 */
public class JobsInstaller implements FeatureInstaller<Job>, TypeInstaller<Job> {

	private final Reporter reporter = new Reporter(JobsInstaller.class, "jobs =");

	@Override
	public void install(final Environment environment, final Class<Job> type) {
		// here we can also look for class annotations and show more info in console
		// (omitted for simplicity)
		reporter.line("(%s)", type.getName());
	}

	@Override
	public boolean matches(final Class<?> type) {
		return FeatureUtils.is(type, Job.class);
	}

	@Override
	public void report() {
		reporter.report();
	}

}
