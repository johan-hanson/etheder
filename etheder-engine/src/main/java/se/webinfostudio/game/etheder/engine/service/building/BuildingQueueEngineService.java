package se.webinfostudio.game.etheder.engine.service.building;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.slf4j.Logger;

import se.webinfostudio.game.etheder.engine.dao.building.BuildingDAO;
import se.webinfostudio.game.etheder.engine.dao.building.BuildingQueueDAO;
import se.webinfostudio.game.etheder.engine.dao.player.CityDAO;
import se.webinfostudio.game.etheder.engine.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 */
public class BuildingQueueEngineService {

	private final static Logger LOGGER = getLogger(BuildingQueueEngineService.class);

	private final BuildingQueueDAO buildingQueueDAO;

	private final BuildingDAO buildingDAO;

	private final CityDAO cityDAO;

	private final PlayerDAO playerDAO;

	public BuildingQueueEngineService(final BuildingQueueDAO buildingQueueDAO,
			final BuildingDAO buildingDAO,
			final CityDAO cityDAO,
			final PlayerDAO playerDAO) {
		// Temporary solution until I fix better DAO
		this.buildingQueueDAO = buildingQueueDAO;
		this.buildingDAO = buildingDAO;
		this.cityDAO = cityDAO;
		this.playerDAO = playerDAO;
	}

	public BuildingQueueEngineService(final Session session) {
		buildingQueueDAO = new BuildingQueueDAO(session);
		buildingDAO = new BuildingDAO(session);
		cityDAO = new CityDAO(session);
		playerDAO = new PlayerDAO(session);
	}

	/**
	 * Updates all queues. If a building is finished the building gets added to the
	 * city.
	 */
	public void updateAllQueuesAndBuildBuildings() {
		LOGGER.info("Start updateAllQueuesAndBuildBuildings");
		final int nrOfRowsUpdated = buildingQueueDAO.decreaseTicks();
		if (nrOfRowsUpdated > 0) {
			final List<BuildingQueue> buildingQueues = buildingQueueDAO.findAllFinished();

			buildingQueues.forEach(bq -> {
				final City city = cityDAO.findByRef(bq.getCity());
				final Optional<Player> player = playerDAO.findByCity(bq.getCity());
				city.addBuilding(buildingDAO.createBuilding(bq.getBuilding()));
				player.ifPresent(p -> playerDAO.persist(p));
//				player.addTechLevel(bq.getBuilding().getUnitType());
				cityDAO.persist(city);
				buildingQueueDAO.remove(bq);
			});

		}
		LOGGER.info("End updateAllQueuesAndBuildBuildings");
	}
}
