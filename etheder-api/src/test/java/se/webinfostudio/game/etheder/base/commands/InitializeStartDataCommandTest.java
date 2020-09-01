package se.webinfostudio.game.etheder.base.commands;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import io.dropwizard.setup.Environment;
import net.sourceforge.argparse4j.inf.Namespace;
import se.webinfostudio.game.etheder.ApiConfiguration;
import se.webinfostudio.game.etheder.dataimport.ImportFromExcel;

/**
 *
 * @author Johan Hanson
 *
 */
public class InitializeStartDataCommandTest {

	@InjectMocks
	private InitializeStartDataCommand sut;

	@Mock
	private ImportFromExcel importFromExcel;

	@Mock
	private Environment environment;

	@Mock
	private Namespace namespace;

	@Mock
	private ApiConfiguration configuration;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		sut.setImportFromExcel(importFromExcel);
	}

	@Test
	void run() throws Exception {
		sut.run(environment, namespace, configuration);

		verify(importFromExcel).startImport();
	}
}
