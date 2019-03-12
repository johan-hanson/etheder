package se.webinfostudio.game.etheder.service.building;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.building.BuildingDAO;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.unit.UnitType;

/**
 *
 * @author Johan Hanson
 */
@Named
public class BuildingService {

	@Inject
	private BuildingDAO buildingDAO;

	public Building createBuilding() {
		final BuildingData buildingData = new BuildingData();
		buildingData.setId(Long.valueOf(1));
		buildingData.setCostFood(0);
		buildingData.setCostGold(10);
		buildingData.setCostIron(0);
		buildingData.setCostWood(10);
		buildingData.setDescription("My test building");
		buildingData.setMaxNumber(3);
		buildingData.setName("MyTest");
		buildingData.setPopulationCapacity(0);
		buildingData.setTicks(10);
		buildingData.setUnitType(UnitType.INFANTRY);
		final Building building = new Building();
		building.setBuildingData(buildingData);
		buildingDAO.create(building);
		return building;
	}

	/**
	 * .
	 *
	 * @return .
	 */
	public List<Building> findAll() {
		return buildingDAO.findAll();
	}

	/**
	 * Finds a building by it id.
	 *
	 * @param buildingId the buidling id
	 * @return {@link Building}
	 */
	public Optional<Building> findById(final String buildingId) {
		return Optional.ofNullable(buildingDAO.findById(UUID.fromString(buildingId)));
	}
}
