package se.webinfostudio.game.etheder.api.model.building;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingModel {

	public static final class Builder {

		private String buildingId;
		private String name;

		public BuildingModel build() {
			final BuildingModel buildingModel = new BuildingModel();
			buildingModel.buildingId = buildingId;
			buildingModel.name = name;
			return buildingModel;
		}

		public Builder withBuildingId(final String buildingId) {
			this.buildingId = buildingId;
			return this;
		}

		public Builder withName(final String name) {
			this.name = name;
			return this;
		}
	}

	public static Builder newBuilder() {
		return new BuildingModel.Builder();
	}

	@JsonProperty("buildingId")
	private String buildingId;

	@JsonProperty("name")
	private String name;

	public BuildingModel() {

	}

	public String getBuildingId() {
		return buildingId;
	}

	public String getName() {
		return name;
	}

}
