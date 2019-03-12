package se.webinfostudio.game.etheder.dao.building;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import se.webinfostudio.game.etheder.dao.AbstractManualDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueManualDAO extends AbstractManualDAO<BuildingQueue> {

	@Inject
	public BuildingQueueManualDAO(final SessionFactory sessionFactory) {
		super(sessionFactory, BuildingQueue.class);
	}

}
