package se.webinfostudio.game.etheder.service.building;

import static java.lang.String.format;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.building.BuildingDataDAO;
import se.webinfostudio.game.etheder.dao.building.BuildingQueueDAO;
import se.webinfostudio.game.etheder.dao.player.CityDAO;
import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
@Named
public class BuildingQueueService {

	@Inject
	private BuildingDataDAO buildingDataDAO;

	@Inject
	private BuildingQueueDAO buildingQueueDAO;

	@Inject
	private CityDAO cityDAO;

	@Inject
	private PlayerDAO playerDAO;

	@Inject
	private WalletService walletService;

	/**
	 * Create a {@link BuildingQueue}
	 *
	 * @param buildingQueue {@link BuildingQueue} to create
	 * @param userId        the id on the user
	 * @return the created {@link BuildingQueue}
	 */
	public BuildingQueue createBuildingQueue(final BuildingQueue buildingQueue, final UUID userId) {
		final UUID cityId = buildingQueue.getCity().getId();
		final City city = findCity(cityId);
		final Player player = findPlayer(userId);

		validateCityBelongsToPlayer(cityId, userId, city, player);

		final BuildingData buildingData = findBuildingData(buildingQueue.getBuilding().getId());

		// Check if building can be built techlevel stuff, to decided

		walletService.pay(player, buildingData);

		buildingQueue.setTicks(buildingData.getTicks());
		buildingQueue.setBuilding(buildingData);
		buildingQueueDAO.persist(buildingQueue);
		playerDAO.persist(player);
		return buildingQueue;
	}

	/**
	 * .
	 *
	 * @param city the city
	 * @return list of {@link BuildingQueue}
	 */
	public List<BuildingQueue> findByCity(final City city) {
//		return buildingQueueRepository.findByCity(city);
		return null;
	}

	private BuildingData findBuildingData(final Long buildingId) {
		final Optional<BuildingData> buildingData = buildingDataDAO.findById(buildingId);

		if (!buildingData.isPresent()) {
			throw new RuntimeException("BuildingData not found: " + buildingId);
		}
		return buildingData.get();
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

	private void validateCityBelongsToPlayer(final UUID cityId, final UUID userId, final City city,
			final Player player) {
		if (!city.getPlayer().getId().equals(player.getId())) {
			throw new RuntimeException(
					format("City %s does not belong to user %s", cityId.toString(), userId.toString()));
		}
	}

}
