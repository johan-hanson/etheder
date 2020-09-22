package se.webinfostudio.game.etheder.api.transformer.building;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.building.BuildingModel;
import se.webinfostudio.game.etheder.entity.building.Building;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingModelTransformer implements Function<Building, BuildingModel> {

	@Override
	public BuildingModel apply(final Building building) {
		return BuildingModel.newBuilder()
				.withBuildingId(building.getId().toString())
//				.withName(building.getBuildingData().getName())
				.build();
	}

}
