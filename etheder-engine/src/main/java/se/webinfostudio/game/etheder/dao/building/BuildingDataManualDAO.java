package se.webinfostudio.game.etheder.dao.building;

import java.util.Optional;

import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataManualDAO {

	public Optional<BuildingData> findById(final Long buildingId) {
		// return Optional.ofNullable(getSession().find(BuildingData.class,
		// buildingId));
		return Optional.empty();
	}

	public BuildingData persist(final BuildingData buildingData) {
		// return super.persist(buildingData);
		return null;
	}
}
