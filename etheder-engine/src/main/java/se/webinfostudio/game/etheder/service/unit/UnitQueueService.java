package se.webinfostudio.game.etheder.service.unit;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

/**
 *
 * @author Johan Hanson
 */
@Named
public class UnitQueueService implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7957551343625127504L;

//	@Inject
//	private UnitQueueRepository unitQueueRepository;

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

	/**
	 * Starts a new training.
	 *
	 * @param unit     the unit to train
	 * @param playerId the playerid for the user
	 * @param cityId   the cityid for the city
	 *
	 *                 TODO: FIXA playerid!!!!
	 */
	public void train(final UnitData unit, final UUID playerId, final UUID cityId) {
		final UnitQueue unitQueue = new UnitQueue();
		unitQueue.setUnit(unit);
		unitQueue.setTicks(unit.getTicks());
		unitQueue.setCity(new CityRef(cityId));
//		unitQueueRepository.create(unitQueue);
	}

}
