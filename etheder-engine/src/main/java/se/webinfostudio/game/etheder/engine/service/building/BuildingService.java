package se.webinfostudio.game.etheder.engine.service.building;

import se.webinfostudio.game.etheder.engine.dao.building.BuildingDAO;

/**
 * Do I need this?
 *
 * @author Johan Hanson
 *
 */
public class BuildingService {

	private final BuildingDAO buildingDAO;

	public BuildingService() {
		buildingDAO = new BuildingDAO();
	}

}
