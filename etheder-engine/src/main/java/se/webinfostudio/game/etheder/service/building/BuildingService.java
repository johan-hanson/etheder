package se.webinfostudio.game.etheder.service.building;

import static java.lang.String.format;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.building.BuildingDAO;
import se.webinfostudio.game.etheder.dao.building.BuildingDataDAO;
import se.webinfostudio.game.etheder.dao.building.BuildingQueueDAO;
import se.webinfostudio.game.etheder.dao.player.CityDAO;
import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 */
@Named
public class BuildingService {

	@Inject
	private BuildingDAO buildingDAO;

	@Inject
	private BuildingDataDAO buildingDataDAO;

	@Inject
	private BuildingQueueDAO buildingQueueDAO;

	@Inject
	private CityDAO cityDAO;

	@Inject
	private PlayerDAO playerDAO;

	public BuildingQueue createBuilding(final Long buildingDataId, final UUID cityId, final UUID userId) {
		final City city = findCity(cityId);
		final Player player = findPlayer(userId);

		validateCityAndPlayer(cityId, userId, city, player);

		final BuildingData buildingData = buildingDataDAO.findById(buildingDataId);

		// Check if building can be built

		// Remove resources from player

		// Create buildingQueue

		// Save data
		final BuildingQueue buildingQueue = createBuildingQueue(cityId, buildingData);

		buildingQueueDAO.persist(buildingQueue);
		playerDAO.persist(player);
		return buildingQueue;
	}

	/**
	 * .
	 *
	 * @return .
	 */
	public List<Building> findAll() {
		return buildingDAO.findAll();
	}

	/**
	 * Finds a building by it id.
	 *
	 * @param buildingId the buidling id
	 * @return {@link Building}
	 */
	public Optional<Building> findById(final String buildingId) {
		return Optional.ofNullable(buildingDAO.findById(UUID.fromString(buildingId)));
	}

	private BuildingQueue createBuildingQueue(final UUID cityId, final BuildingData buildingData) {
		final BuildingQueue buildingQueue = new BuildingQueue();
		buildingQueue.setBuilding(buildingData);
		buildingQueue.setCity(new CityRef(cityId));
		buildingQueue.setTicks(buildingData.getTicks());
		return buildingQueue;
	}

	private City findCity(final UUID cityId) {
		final Optional<City> city = cityDAO.findById(cityId);

		if (!city.isPresent()) {
			throw new RuntimeException("City not found: " + cityId.toString());
		}
		return city.get();
	}

	private Player findPlayer(final UUID userId) {
		final Optional<Player> player = playerDAO.findByUserId(userId);

		if (!player.isPresent()) {
			throw new RuntimeException("Player not found for user: " + userId);
		}
		return player.get();
	}

	private void validateCityAndPlayer(final UUID cityId, final UUID userId, final City city, final Player player) {
		if (!city.getPlayer().getId().equals(player.getId())) {
			throw new RuntimeException(
					format("City %s does not belong to user %s", cityId.toString(), userId.toString()));
		}
	}
}
