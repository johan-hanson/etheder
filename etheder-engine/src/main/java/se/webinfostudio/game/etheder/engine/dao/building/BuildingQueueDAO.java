package se.webinfostudio.game.etheder.engine.dao.building;

import java.util.List;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 * DAO for {@link BuildingQueue} in engine module.
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueDAO extends AbstractDAO<BuildingQueue> {

	public BuildingQueueDAO(final Session session) {
		super(session, BuildingQueue.class);
	}

	/**
	 * Decrease the tciks for all {@link BuildingQueue}s
	 *
	 * @return # of rows updated
	 */
	public int decreaseTicks() {
		return super.insertUpdateNamedQuery("BuildingQueue.decreaseTicks");
	}

	/**
	 * Gets all {@link BuildingQueue}s that has 0 ticks.
	 *
	 * @return List of {@link BuildingQueue}.
	 */
	public List<BuildingQueue> findAllFinished() {
		return super.findByNamedQuery("BuildingQueue.findAllFinished");
	}

}
