package se.webinfostudio.game.etheder.engine.dao.unit;

import java.util.List;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class UnitQueueDAO extends AbstractDAO<UnitQueue> {

	public UnitQueueDAO(final Session session) {
		super(session, UnitQueue.class);
	}

	/**
	 * Decrease the tciks for all {@link BuildingQueue}s
	 *
	 * @return # of rows updated
	 */
	public int decreaseTicks() {
		return super.insertUpdateNamedQuery("UnitQueue.decreaseTicks");
	}

	/**
	 * Gets all {@link UnitQueue}s that has 0 ticks.
	 *
	 * @return List of {@link UnitQueue}.
	 */
	public List<UnitQueue> findAllFinished() {
		return super.findByNamedQuery("UnitQueue.findAllFinished");
	}

}
