package se.webinfostudio.game.etheder.engine.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.player.ArmyDAO;
import se.webinfostudio.game.etheder.engine.dao.player.CityDAO;
import se.webinfostudio.game.etheder.engine.dao.unit.UnitQueueDAO;
import se.webinfostudio.game.etheder.entity.player.Army;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

/**
 *
 * @author Johan Hanson
 */
@Named
public class UnitQueueEngineService {

	@Inject
	private final ArmyDAO armyDAO;

	@Inject
	private final UnitQueueDAO unitQueueDAOy;

	@Inject
	private final CityDAO cityDAO;

	public UnitQueueEngineService(final Session session) {
		unitQueueDAOy = new UnitQueueDAO(session);
		armyDAO = new ArmyDAO(session);
		cityDAO = new CityDAO(session);
	}

	/**
	 * Updates all queues and creates the units if the queue has reached 0 ticks
	 * left.
	 */
	public void updateAllQueuesAndCreateUnits() {
		final int nrOfRowsUpdated = unitQueueDAOy.decreaseTicks();
		if (nrOfRowsUpdated > 0) {
			final List<UnitQueue> unitQueues = unitQueueDAOy.findAllFinished();

			unitQueues.forEach(uq -> {
				final City city = cityDAO.findByRef(uq.getCity());
				city.getArmyList().forEach(aRef -> {
					final Army army = armyDAO.findByRef(aRef);
					if (army.getDefaultArmy()) {
						army.addUnits(uq.getUnit().getUnitType(), uq.getNrOfUnits());
						armyDAO.persist(army);
					}
				});
				unitQueueDAOy.remove(uq);
			});
		}
	}
}
