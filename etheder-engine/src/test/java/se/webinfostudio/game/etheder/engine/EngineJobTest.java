package se.webinfostudio.game.etheder.engine;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EngineJobTest {

	@InjectMocks
	private EngineJob sut;

	@Mock
	private EngineService ethederEngineService;

	@Mock
	private JobExecutionContext context;

	@Test
	void doJob() throws JobExecutionException {
		sut.doJob(context);

		verify(ethederEngineService).runService();
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}
}
