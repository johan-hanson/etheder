package se.webinfostudio.game.etheder.api.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityModel {

	public static final class Builder {

		private String cityId;
		private String name;
		private String playerId;

		public CityModel build() {
			final CityModel cityModel = new CityModel();
			cityModel.cityId = cityId;
			cityModel.name = name;
			cityModel.playerId = playerId;
			return cityModel;
		}

		public Builder withCityId(final String cityId) {
			this.cityId = cityId;
			return this;
		}

		public Builder withName(final String name) {
			this.name = name;
			return this;
		}

		public Builder withPlayerId(final String playerId) {
			this.playerId = playerId;
			return this;
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@JsonProperty
	private String cityId;

	@JsonProperty
	private String name;

	@JsonProperty
	private String playerId;

	public String getCityId() {
		return cityId;
	}

	public String getName() {
		return name;
	}

	public String getPlayerId() {
		return playerId;
	}
}
