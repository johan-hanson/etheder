package se.webinfostudio.game.etheder.api.transformer.building;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.CityRef;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueTransformer implements Function<BuildingQueueModel, BuildingQueue> {

	@Override
	public BuildingQueue apply(final BuildingQueueModel buildingQueueModel) {
		final BuildingQueue buildingQueue = new BuildingQueue();
		buildingQueue.setBuilding(createBuildingData(buildingQueueModel));
		buildingQueue.setCity(new CityRef(fromString(buildingQueueModel.getCityId())));
		return buildingQueue;
	}

	private BuildingData createBuildingData(final BuildingQueueModel buildingQueueModel) {
		final BuildingData buildingData = new BuildingData();
		buildingData.setId(buildingQueueModel.getBuildingId());
		buildingData.setName(buildingQueueModel.getBuildingName());
		buildingData.setDescription(buildingQueueModel.getDescription());
		return buildingData;
	}

}
