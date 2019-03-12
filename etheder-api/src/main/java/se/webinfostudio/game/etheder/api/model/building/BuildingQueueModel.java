package se.webinfostudio.game.etheder.api.model.building;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueModel {

	public static final class Builder {

		private String buildingQueueId;
		private Long buildingId;
		private String buildingName;
		private String description;
		private String cityId;

		public BuildingQueueModel build() {
			final BuildingQueueModel buildingQueueModel = new BuildingQueueModel();
			buildingQueueModel.buildingQueueId = buildingQueueId;
			buildingQueueModel.buildingId = buildingId;
			buildingQueueModel.buildingName = buildingName;
			buildingQueueModel.cityId = cityId;
			buildingQueueModel.description = description;
			return buildingQueueModel;
		}

		public Builder withBuildingId(final Long buildingId) {
			this.buildingId = buildingId;
			return this;
		}

		public Builder withBuildingName(final String buildingName) {
			this.buildingName = buildingName;
			return this;
		}

		public Builder withBuildingQueueId(final String buildingQueueId) {
			this.buildingQueueId = buildingQueueId;
			return this;
		}

		public Builder withCityId(final String cityId) {
			this.cityId = cityId;
			return this;
		}

		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	private String buildingQueueId;

	private Long buildingId;

	private String buildingName;

	private String cityId;

	private String description;

	public Long getBuildingId() {
		return buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public String getBuildingQueueId() {
		return buildingQueueId;
	}

	public String getCityId() {
		return cityId;
	}

	public String getDescription() {
		return description;
	}
}
