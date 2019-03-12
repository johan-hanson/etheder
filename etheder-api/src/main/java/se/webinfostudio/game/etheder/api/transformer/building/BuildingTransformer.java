package se.webinfostudio.game.etheder.api.transformer.building;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.building.BuildingModel;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingTransformer implements Function<BuildingModel, Building> {

	@Override
	public Building apply(final BuildingModel buildingModel) {
		final Building building = new Building();
		building.setId(fromString(buildingModel.getBuildingId()));
		building.setBuildingData(createBuildingData(buildingModel));
		return building;
	}

	private BuildingData createBuildingData(final BuildingModel buildingModel) {
		final BuildingData buildingData = new BuildingData();
		buildingData.setName(buildingModel.getName());
		return buildingData;
	}

}
