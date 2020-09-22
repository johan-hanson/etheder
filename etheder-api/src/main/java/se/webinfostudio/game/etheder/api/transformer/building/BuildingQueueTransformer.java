package se.webinfostudio.game.etheder.api.transformer.building;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueTransformer implements Function<BuildingQueueModel, BuildingQueue> {

	@Override
	public BuildingQueue apply(final BuildingQueueModel buildingQueueModel) {
		final BuildingQueue buildingQueue = new BuildingQueue();
		buildingQueue.setBuildingId(buildingQueueModel.getBuildingId());
		buildingQueue.setCityId(fromString(buildingQueueModel.getCityId()));
		return buildingQueue;
	}

}
