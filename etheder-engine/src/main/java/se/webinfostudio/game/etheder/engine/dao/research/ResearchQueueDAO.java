package se.webinfostudio.game.etheder.engine.dao.research;

import java.util.List;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchQueueDAO extends AbstractDAO<ResearchQueue> {

	public ResearchQueueDAO() {
		super(ResearchQueue.class);
	}

	/**
	 * Decrease the tciks for all {@link BuildingQueue}s
	 *
	 * @return # of rows updated
	 */
	public int decreaseTicks() {
		return super.insertUpdateNamedQuery("ResearchQueue.decreaseTicks");
	}

	/**
	 * Gets all {@linkResearchQueue}s that has 0 ticks.
	 *
	 * @return List of {@link ResearchQueue}.
	 */
	public List<ResearchQueue> findAllFinished() {
		return super.findByNamedQuery("ResearchQueue.findAllFinished");
	}

}
