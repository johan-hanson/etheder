package se.webinfostudio.game.etheder.api.transformer.unit;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.unit.UnitQueueModel;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class UnitQueueModelTransformer implements Function<UnitQueue, UnitQueueModel> {

	@Override
	public UnitQueueModel apply(final UnitQueue unitQueue) {
		return UnitQueueModel.newBuilder()
				.withUnitQueueId(unitQueue.getId().toString())
				.withUnitId(unitQueue.getUnit().getId())
				.withUnitName(unitQueue.getUnit().getName())
				.withCityId(unitQueue.getCity().getId().toString())
				.withDescription(unitQueue.getUnit().getDescription())
				.withNumberOf(unitQueue.getNrOfUnits())
				.build();
	}

}
