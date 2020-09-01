package se.webinfostudio.game.etheder;

import static ru.vyarus.dropwizard.guice.GuiceBundle.builder;
import static se.webinfostudio.game.etheder.base.BaseModule.baseModule;
import static se.webinfostudio.game.etheder.domain.auth.AuthModule.authModule;

import java.util.logging.LogManager;

import org.slf4j.bridge.SLF4JBridgeHandler;

import com.codahale.metrics.SharedMetricRegistries;

import de.spinscale.dropwizard.jobs.Job;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.provider.JerseyProviderInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.web.WebFilterInstaller;
import ru.vyarus.guicey.jdbi3.JdbiBundle;

/**
 *
 * @author Johan Hanson
 *
 */
public class ApiApplication extends Application<ApiConfiguration> {

	public static void main(final String[] args) throws Exception {
		new ApiApplication().run(args);
	}

	@Override
	public String getName() {
		return "Etheder-API";
	}

	@Override
	public void initialize(final Bootstrap<ApiConfiguration> bootstrap) {
		LogManager.getLogManager().reset();
		SLF4JBridgeHandler.install();

		bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
				bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));

		bootstrap.addBundle(builder().modules(
				baseModule(),
				authModule())
				.bundles(JdbiBundle.<ApiConfiguration>forDatabase((conf, env) -> conf.getDatabase()))
				.installers(JerseyProviderInstaller.class, WebFilterInstaller.class)
				.enableAutoConfig(ApiApplication.class.getPackage().getName())
				.searchCommands().build());

		// force dropwizard-jobs using main metrics registry for all jobs
		SharedMetricRegistries.add(Job.DROPWIZARD_JOBS_KEY, bootstrap.getMetricRegistry());
	}

	@Override
	public void run(final ApiConfiguration configuration, final Environment environment) throws Exception {
//		final JdbiFactory factory = new JdbiFactory();
//		final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
//		environment.jersey().register(new UserResource(jdbi));

//		final TestHealthCheck healthCheck = new TestHealthCheck(configuration.getTest());
//		environment.healthChecks().register("test", healthCheck);

//		LOG.info("sesionFactory: {}", hibernate.getSessionFactory());

//		CustomAuthenticator authenticator = new UnitOfWorkAwareProxyFactory(hibernate)
//	      .create(CustomAuthenticator.class, new Class<?>[]{TokenDAO.class, UserDAO.class}, new Object[]{tokenDAO, userDAO});
//	    CustomAuthFilter filter = new CustomAuthFilter(authenticator);
//
//	    environment.jersey().register(new AuthDynamicFeature(filter));

//		final UnitDataDAO unitDataDAO = new UnitDataDAO(hibernate.getSessionFactory());
//
//		final UnitDataService unitDataService = new UnitOfWorkAwareProxyFactory(hibernate)
//				.create(UnitDataService.class, UnitDataDAO.class, unitDataDAO);
//
//		environment.jersey().register(unitDataService);
	}
}
