package se.webinfostudio.game.etheder.engine.dao.building;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDAO extends AbstractDAO<Building> {

	public BuildingDAO(final Session session) {
		super(session, Building.class);
	}

	/**
	 * Creates a {@link Building} and saves it.
	 *
	 * @param buildingData {@link BuildingData}
	 * @return A {@link Building}
	 */
	public Building createBuilding(final BuildingData buildingData) {
		final Building building = new Building();
		building.setBuildingData(buildingData);
		persist(building);
		return building;
	}

}
