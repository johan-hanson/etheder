package se.webinfostudio.game.etheder.api.model.user;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserChangePasswordModel {

	public static final class Builder {

		private String oldPassword;
		private String newPassword;

		public UserChangePasswordModel build() {
			final UserChangePasswordModel userModel = new UserChangePasswordModel();
			userModel.oldPassword = oldPassword;
			userModel.newPassword = newPassword;
			return userModel;
		}

		public Builder withNewPassword(final String newPassword) {
			this.newPassword = newPassword;
			return this;
		}

		public Builder withOldPassword(final String oldPassword) {
			this.oldPassword = oldPassword;
			return this;
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	@NotBlank
	@JsonProperty
	private String oldPassword;

	@NotBlank
	@JsonProperty
	private String newPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}
}
