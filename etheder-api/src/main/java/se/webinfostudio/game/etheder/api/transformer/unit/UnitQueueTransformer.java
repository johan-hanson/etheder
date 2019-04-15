package se.webinfostudio.game.etheder.api.transformer.unit;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.unit.UnitQueueModel;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

public class UnitQueueTransformer implements Function<UnitQueueModel, UnitQueue> {

	@Override
	public UnitQueue apply(final UnitQueueModel unitQueueModel) {
		final UnitQueue unitgQueue = new UnitQueue();
		unitgQueue.setUnit(createUnitData(unitQueueModel));
		unitgQueue.setCity(new CityRef(fromString(unitQueueModel.getCityId())));
		unitgQueue.setNrOfUnits(unitQueueModel.getNumberOf());
		return unitgQueue;
	}

	private UnitData createUnitData(final UnitQueueModel unitQueueModel) {
		final UnitData buildingData = new UnitData();
		buildingData.setId(unitQueueModel.getUnitId());
		buildingData.setName(unitQueueModel.getUnitName());
		buildingData.setDescription(unitQueueModel.getDescription());
		return buildingData;
	}

}
