package se.webinfostudio.game.etheder.engine;

import static org.slf4j.LoggerFactory.getLogger;

import javax.inject.Named;

import org.slf4j.Logger;

import se.webinfostudio.game.etheder.engine.service.PlayerEngineService;
import se.webinfostudio.game.etheder.engine.service.ResearchQueueEngineService;
import se.webinfostudio.game.etheder.engine.service.UnitQueueEngineService;
import se.webinfostudio.game.etheder.engine.service.building.BuildingQueueEngineService;

/**
 *
 * @author Johan Hanson
 */
@Named
public class EngineService {

	private static final Logger LOGGER = getLogger(EngineService.class);

	private BuildingQueueEngineService buildingQueueEngineService;

	private ResearchQueueEngineService researchQueueEngineService;

	private UnitQueueEngineService unitQueueEngineService;

	private PlayerEngineService playerEngineService;

	public EngineService() {
	}

	/**
	 * Runs the engine service.
	 */
	public void runService() {

		try {
			run();
		} finally {
		}

	}

	private void initialize() {
		buildingQueueEngineService = new BuildingQueueEngineService();
		researchQueueEngineService = new ResearchQueueEngineService();
		unitQueueEngineService = new UnitQueueEngineService();
	}

	private void run() {
		// here goes the order of the engine
		// i.e.
		LOGGER.info("Before building");
		buildingQueueEngineService.updateAllQueuesAndBuildBuildings();
		LOGGER.info("Before research");
		researchQueueEngineService.updateAllQueuesAndCreateResearches();
		LOGGER.info("Before units");
		unitQueueEngineService.updateAllQueuesAndCreateUnits();

//		playerEngineService.updateResources();

		LOGGER.info("runService finished");
		// travel armies
		// fight
	}

}
