package se.webinfostudio.game.etheder.api.transformer.building;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.building.BuildingModel;
import se.webinfostudio.game.etheder.entity.building.Building;

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
		return building;
	}

}
