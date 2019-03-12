package se.webinfostudio.game.etheder.dao.building;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueDAO extends AbstractDAO<BuildingQueue> {

	@Inject
	public BuildingQueueDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public BuildingQueue persist(final BuildingQueue buildingQueue) {
		return super.persist(buildingQueue);
	}
}
