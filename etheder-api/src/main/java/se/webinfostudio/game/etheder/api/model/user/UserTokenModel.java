package se.webinfostudio.game.etheder.api.model.user;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserTokenModel {

	public static final class Builder {

		private String userName;
		private String token;

		public UserTokenModel build() {
			final UserTokenModel userTokenModel = new UserTokenModel();
			userTokenModel.userName = userName;
			userTokenModel.token = token;
			return userTokenModel;
		}

		public Builder withToken(final String token) {
			this.token = token;
			return this;
		}

		public Builder withUserName(final String userName) {
			this.userName = userName;
			return this;
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@NotBlank
	@JsonProperty
	private String userName;

	@NotBlank
	@JsonProperty
	private String token;

	public String getToken() {
		return token;
	}

	public String getUserName() {
		return userName;
	}

}
