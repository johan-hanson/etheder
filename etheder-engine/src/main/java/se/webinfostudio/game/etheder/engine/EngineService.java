package se.webinfostudio.game.etheder.engine;

import static org.slf4j.LoggerFactory.getLogger;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	private final SessionFactory sessionFactory;

	@Inject
	public EngineService(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Runs the engine service.
	 */
	public void runService() {
		final Session session = initialize();

		try {
			run();
		} finally {
			closeSession(session);
		}

	}

	private void closeSession(final Session session) {
		final Transaction transaction = session.getTransaction();
		if (transaction.getRollbackOnly()) {
			transaction.rollback();
		} else {
			transaction.commit();
		}
		session.close();
	}

	private Session initialize() {
		final Session session = sessionFactory.openSession();

		buildingQueueEngineService = new BuildingQueueEngineService(session);
		researchQueueEngineService = new ResearchQueueEngineService(session);
		unitQueueEngineService = new UnitQueueEngineService(session);

		session.beginTransaction();

		return session;
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
