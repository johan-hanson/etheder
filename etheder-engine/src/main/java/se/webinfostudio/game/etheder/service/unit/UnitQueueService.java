package se.webinfostudio.game.etheder.service.unit;

import static java.lang.String.format;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.dao.player.CityDAO;
import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.dao.unit.UnitDataDAO;
import se.webinfostudio.game.etheder.engine.dao.unit.UnitQueueDAO;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
public class UnitQueueService {

	@Inject
	private CityDAO cityDAO;

	@Inject
	private PlayerDAO playerDAO;

	@Inject
	private UnitDataDAO unitDataDAO;

	@Inject
	private UnitQueueDAO unitQueueDAO;

	@Inject
	private WalletService walletService;

	/**
	 * Create an {@link UnitQueue}
	 *
	 * @param unitQueue {@link UnitQueue} to create
	 * @param userId    the id on the user
	 * @return the created {@link UnitQueue}
	 */
	public UnitQueue createUnitQueue(final UnitQueue unitQueue, final UUID userId) {
		final UUID cityId = unitQueue.getCity().getId();
		final City city = findCity(cityId);
		final Player player = findPlayer(userId);

		validateCityBelongsToPlayer(cityId, userId, city, player);

		final UnitData unitData = findUnitData(unitQueue.getUnit().getId());

		// Check if unit can be built techlevel stuff, to decided

		walletService.pay(player, unitData);

		unitQueue.setTicks(unitData.getTicks());
//		sunitQueueDAO.persist(unitQueue);
		playerDAO.persist(player);
		return unitQueue;
	}

	/**
	 * Finds a list of unitques by the city entity.
	 *
	 * @param city {@link City}
	 * @return a list of unit queues
	 */
	public List<UnitQueue> findByCity(final City city) {
//		return unitQueueRepository.findByCity(city);
		return null;
	}

	public UnitQueue listUnitQueues(final String cityId, final String userId) {
		// TODO Auto-generated method stub
		return null;
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

	private UnitData findUnitData(final Long unitId) {
		final Optional<UnitData> unitdData = unitDataDAO.findById(unitId);

		if (!unitdData.isPresent()) {
			throw new RuntimeException("UnitData not found: " + unitId);
		}
		return unitdData.get();
	}

	private void validateCityBelongsToPlayer(final UUID cityId, final UUID userId, final City city,
			final Player player) {
		if (!city.getPlayer().getId().equals(player.getId())) {
			throw new RuntimeException(
					format("City %s does not belong to user %s", cityId.toString(), userId.toString()));
		}
	}
}
