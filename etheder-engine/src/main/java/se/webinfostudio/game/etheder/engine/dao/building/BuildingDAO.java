package se.webinfostudio.game.etheder.engine.dao.building;

import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDAO {

	/**
	 * Creates a {@link Building} and saves it.
	 *
	 * @param buildingData {@link BuildingData}
	 * @return A {@link Building}
	 */
	public Building createBuilding(final BuildingData buildingData) {
		final Building building = new Building();
		building.setBuildingDataId(buildingData.getId());
//		persist(building);
		return building;
	}

}
