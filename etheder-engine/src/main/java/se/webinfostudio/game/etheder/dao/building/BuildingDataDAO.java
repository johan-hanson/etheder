package se.webinfostudio.game.etheder.dao.building;

import java.util.Optional;

import com.google.inject.Inject;

import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataDAO {

	@Inject
	public BuildingDataDAO() {
	}

	public Optional<BuildingData> findById(final Long buildingId) {
		// return ofNullable(currentSession().find(BuildingData.class, buildingId));
		return Optional.empty();
	}

	public BuildingData persist(final BuildingData entity) {
		// return super.persist(entity);
		return null;
	}
}
