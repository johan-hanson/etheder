package se.webinfostudio.game.etheder.engine.service.building;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.repository.building.BuildingDataRepository;
import se.webinfostudio.game.etheder.repository.building.BuildingQueueRepository;
import se.webinfostudio.game.etheder.repository.building.BuildingRepository;
import se.webinfostudio.game.etheder.repository.player.CityRepository;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;

/**
 *
 * @author Johan Hanson
 */
public class BuildingQueueEngineService {

	private final static Logger LOGGER = getLogger(BuildingQueueEngineService.class);

	@Inject
	private BuildingDataRepository buildingDataRepository;

	@Inject
	private BuildingQueueRepository buildingQueueRepository;

	@Inject
	private BuildingRepository buildingRepository;

	@Inject
	private CityRepository cityRepository;

	@Inject
	private PlayerRepository playerRepository;

	/**
	 * Updates all queues. If a building is finished the building gets added to the
	 * city.
	 */
	public void updateAllQueuesAndBuildBuildings() {
		LOGGER.info("Start updateAllQueuesAndBuildBuildings");
		final int nrOfRowsUpdated = buildingQueueRepository.decreaseTicks();
		if (nrOfRowsUpdated > 0) {
			final List<BuildingQueue> buildingQueues = buildingQueueRepository.findAllFinished();

			buildingQueues.forEach(bq -> {
				final City city = cityRepository.findById(bq.getCityId());
				final Player player = playerRepository.findById(city.getPlayerId());
				final BuildingData buildingData = buildingDataRepository.findById(bq.getBuildingId());
				final Building building = createBuilding(buildingData.getId());
				buildingRepository.create(building);
				city.addBuilding(building);
				player.addTechLevel(buildingData.getUnitType());

				playerRepository.update(player);
				cityRepository.update(city);
				buildingQueueRepository.remove(bq.getId());
			});

		}
		LOGGER.info("End updateAllQueuesAndBuildBuildings");
	}

	private Building createBuilding(final Long buildingId) {
		final Building building = new Building();
		building.setBuildingDataId(buildingId);
		return building;
	}
}
