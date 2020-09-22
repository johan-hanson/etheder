package se.webinfostudio.game.etheder.engine;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.engine.service.PlayerEngineService;
import se.webinfostudio.game.etheder.engine.service.UnitQueueEngineService;
import se.webinfostudio.game.etheder.engine.service.building.BuildingQueueEngineService;
import se.webinfostudio.game.etheder.engine.service.research.ResearchQueueEngineService;

public class EngineServiceTest {

	@InjectMocks
	private EngineService sut;

	@Mock
	private BuildingQueueEngineService buildingQueueEngineService;

	@Mock
	private ResearchQueueEngineService researchQueueEngineService;

	@Mock
	private UnitQueueEngineService unitQueueEngineService;

	@Mock
	private PlayerEngineService playerEngineService;

	@BeforeEach
	protected void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	void run() {
		sut.runService();

		verify(buildingQueueEngineService).updateAllQueuesAndBuildBuildings();
		verify(researchQueueEngineService).updateAllQueuesAndCreateResearches();
		verify(unitQueueEngineService).updateAllQueuesAndCreateUnits();
		verify(playerEngineService).updateResources();
	}

}
