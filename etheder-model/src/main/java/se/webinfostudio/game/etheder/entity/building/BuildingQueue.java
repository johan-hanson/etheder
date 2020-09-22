package se.webinfostudio.game.etheder.entity.building;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractQueueEntity;

/**
 * BuildingQueue, when building a building
 *
 * @author Johan Hanson
 */
public class BuildingQueue extends AbstractQueueEntity {

	private static final long serialVersionUID = 8156980671262090383L;

	@NotNull
	private Long buildingId;

	@NotNull
	private UUID cityId;

	public Long getBuildingId() {
		return buildingId;
	}

	public UUID getCityId() {
		return cityId;
	}

	public void setBuildingId(final Long buildingId) {
		this.buildingId = buildingId;
	}

	public void setCityId(final UUID cityId) {
		this.cityId = cityId;
	}

}
