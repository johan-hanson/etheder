package se.webinfostudio.game.etheder.dao.building;

import java.util.Optional;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import se.webinfostudio.game.etheder.dao.AbstractManualDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataManualDAO extends AbstractManualDAO<BuildingData> {

	@Inject
	public BuildingDataManualDAO(final SessionFactory sessionFactory) {
		super(sessionFactory, BuildingData.class);
	}

	public Optional<BuildingData> findById(final Long buildingId) {
		return Optional.ofNullable(getSession().find(BuildingData.class, buildingId));
	}

	@Override
	public BuildingData persist(final BuildingData buildingData) {
		return super.persist(buildingData);
	}
}
