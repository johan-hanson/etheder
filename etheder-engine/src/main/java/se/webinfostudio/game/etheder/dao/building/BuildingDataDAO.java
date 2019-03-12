package se.webinfostudio.game.etheder.dao.building;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataDAO extends AbstractDAO<BuildingData> {

	@Inject
	public BuildingDataDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public BuildingData findById(final Long buildingId) {
		return currentSession().find(BuildingData.class, buildingId);
	}

	@Override
	public BuildingData persist(final BuildingData entity) {
		return super.persist(entity);
	}
}
