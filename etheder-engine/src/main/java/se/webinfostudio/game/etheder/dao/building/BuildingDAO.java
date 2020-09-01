package se.webinfostudio.game.etheder.dao.building;

import static java.util.Collections.emptyList;

import java.util.List;
import java.util.UUID;

import se.webinfostudio.game.etheder.entity.building.Building;

public class BuildingDAO {

	public BuildingDAO() {
	}

	public UUID create(final Building entity) {
		return null;
	}

	public List<Building> findAll() {
		// return list(currentSession().createQuery("from building"));
		return emptyList();
	}

	public Building findById(final UUID buildingId) {
		// return currentSession().find(Building.class, buildingId);
		return null;
	}
}
