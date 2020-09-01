package se.webinfostudio.game.etheder.base.commands;

import static org.slf4j.LoggerFactory.getLogger;

import javax.inject.Inject;

import org.slf4j.Logger;

import io.dropwizard.Application;
import io.dropwizard.cli.EnvironmentCommand;
import io.dropwizard.setup.Environment;
import net.sourceforge.argparse4j.inf.Namespace;
import se.webinfostudio.game.etheder.ApiConfiguration;
import se.webinfostudio.game.etheder.dataimport.ImportFromExcel;

public final class InitializeStartDataCommand extends EnvironmentCommand<ApiConfiguration> {

	private static final Logger LOG = getLogger(InitializeStartDataCommand.class);

	@Inject
	private ImportFromExcel importFromExcel;

	public InitializeStartDataCommand(final Application<ApiConfiguration> application) {
		super(application, "init-startdata", "Saves startdata to DB");
	}

	@Override
	protected void run(final Environment environment, final Namespace namespace,
			final ApiConfiguration configuration) throws Exception {
		LOG.info("run InitialStartDataCommand");
		importFromExcel.startImport();
	}

	// Used for test since constructor injector not working
	void setImportFromExcel(final ImportFromExcel importFromExcel) {
		this.importFromExcel = importFromExcel;
	}
}
