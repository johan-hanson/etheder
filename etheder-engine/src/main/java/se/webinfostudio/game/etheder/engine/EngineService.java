package se.webinfostudio.game.etheder.engine;

import static org.slf4j.LoggerFactory.getLogger;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.engine.service.PlayerEngineService;
import se.webinfostudio.game.etheder.engine.service.UnitQueueEngineService;
import se.webinfostudio.game.etheder.engine.service.building.BuildingQueueEngineService;
import se.webinfostudio.game.etheder.engine.service.research.ResearchQueueEngineService;

/**
 *
 * @author Johan Hanson
 */
@Named
public class EngineService {

	private static final Logger LOGGER = getLogger(EngineService.class);

	@Inject
	private BuildingQueueEngineService buildingQueueEngineService;

	@Inject
	private ResearchQueueEngineService researchQueueEngineService;

	@Inject
	private UnitQueueEngineService unitQueueEngineService;

	@Inject
	private PlayerEngineService playerEngineService;

	public EngineService() {
	}

	/**
	 * Runs the engine service.
	 */
	public void runService() {

		try {
			run();
		} catch (final Exception e) {
			LOGGER.warn("Exception in engine service", e);
		} finally {
			LOGGER.info("runService finished");
		}

	}

	@InTransaction
	private void run() {
		// here goes the order of the engine
		// i.e.
		LOGGER.info("Before building");
		buildingQueueEngineService.updateAllQueuesAndBuildBuildings();
		LOGGER.info("Before research");
		researchQueueEngineService.updateAllQueuesAndCreateResearches();
		LOGGER.info("Before units");
		unitQueueEngineService.updateAllQueuesAndCreateUnits();

		playerEngineService.updateResources();

		// travel armies
		// fight
	}

}
