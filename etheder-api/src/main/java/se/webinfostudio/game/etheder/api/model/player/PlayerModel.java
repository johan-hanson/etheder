package se.webinfostudio.game.etheder.api.model.player;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerModel {

	public static final class Builder {

		private String playerId;
		private String country;
		private String name;
		private String userId;

		public PlayerModel build() {
			final PlayerModel playerModel = new PlayerModel();
			playerModel.playerId = playerId;
			playerModel.country = country;
			playerModel.name = name;
			playerModel.userId = userId;
			return playerModel;
		}

		public Builder withCountry(final String country) {
			this.country = country;
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

		public Builder withUserId(final String userId) {
			this.userId = userId;
			return this;
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@JsonProperty
	private String playerId;

	@JsonProperty
	@NotEmpty
	private String country;

	@JsonProperty
	@NotEmpty
	private String name;

	@JsonProperty
	@NotEmpty
	private String userId;

	public String getCountry() {
		return country;
	}

	public String getPlayerId() {
		return playerId;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

}
