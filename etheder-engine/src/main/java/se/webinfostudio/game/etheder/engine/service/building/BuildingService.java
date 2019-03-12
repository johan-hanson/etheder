package se.webinfostudio.game.etheder.engine.service.building;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.building.BuildingDAO;

/**
 * Do I need this?
 *
 * @author Johan Hanson
 *
 */
public class BuildingService {

	private final BuildingDAO buildingDAO;

	public BuildingService(final Session session) {
		buildingDAO = new BuildingDAO(session);
	}

}
