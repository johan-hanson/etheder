package se.webinfostudio.game.etheder.service.building;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.repository.building.BuildingDataRepository;
import se.webinfostudio.game.etheder.repository.building.BuildingQueueRepository;
import se.webinfostudio.game.etheder.repository.player.CityRepository;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
@Named
public class BuildingQueueService {

	@Inject
	private BuildingDataRepository buildingDataRepository;

	@Inject
	private BuildingQueueRepository buildingQueueRepository;

	@Inject
	private CityRepository cityRepository;

	@Inject
	private PlayerRepository playerRepository;

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
		final City city = findCity(buildingQueue.getCityId());
		final Player player = findPlayer(userId);

		validateCityBelongsToPlayer(buildingQueue.getCityId(), userId, city, player);

		// Check if building can be built techlevel stuff, to be decided

		final BuildingData buildingData = buildingDataRepository.findById(buildingQueue.getBuildingId());

		// check if buildingqueue for this building already exists, depends if multiple
		// buildings can be created

		walletService.pay(player, buildingData);

		buildingQueue.setTicks(buildingData.getTicks());
		buildingQueueRepository.create(buildingQueue);
//		playerDAO.persist(player);
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

	private City findCity(final UUID cityId) {
		final Optional<City> city = ofNullable(cityRepository.findById(cityId));

		if (!city.isPresent()) {
			throw new RuntimeException("City not found: " + cityId.toString());
		}
		return city.get();
	}

	private Player findPlayer(final UUID userId) {
		final Optional<Player> player = playerRepository.findByUserId(userId);

		if (!player.isPresent()) {
			throw new RuntimeException("Player not found for user: " + userId);
		}
		return player.get();
	}

	private void validateCityBelongsToPlayer(
			final UUID cityId,
			final UUID userId,
			final City city,
			final Player player) {
		if (!city.getPlayer().getId().equals(player.getId())) {
			throw new RuntimeException(
					format("City %s does not belong to user %s", cityId.toString(), userId.toString()));
		}
	}

}
