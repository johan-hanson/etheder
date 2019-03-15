package se.webinfostudio.game.etheder.api.model.user;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Johan Hanson
 *
 */
public class LoginModel {

	public static final class Builder {

		private String userName;
		private String password;

		public LoginModel build() {
			final LoginModel userModel = new LoginModel();
			userModel.userName = userName;
			userModel.password = password;
			return userModel;
		}

		public Builder withPassword(final String password) {
			this.password = password;
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
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
}
