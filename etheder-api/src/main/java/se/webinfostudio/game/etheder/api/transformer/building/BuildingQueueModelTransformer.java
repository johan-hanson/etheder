package se.webinfostudio.game.etheder.api.transformer.building;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueModelTransformer implements Function<BuildingQueue, BuildingQueueModel> {

	@Override
	public BuildingQueueModel apply(final BuildingQueue buildingQueue) {
		return BuildingQueueModel.newBuilder()
				.withBuildingQueueId(buildingQueue.getId().toString())
				.withBuildingId(buildingQueue.getBuildingId())
//				.withBuildingName(buildingQueue.getBuilding().getName())
				.withCityId(buildingQueue.getCityId().toString())
//				.withDescription(buildingQueue.getBuilding().getDescription())
				.build();
	}

}
