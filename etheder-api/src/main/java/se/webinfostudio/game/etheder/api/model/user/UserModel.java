package se.webinfostudio.game.etheder.api.model.user;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserModel {

	public static final class Builder {

		private String userId;
		private String userName;
		private String password;
		private String firstName;
		private String lastName;
		private String country;
		private Integer age;
		private String email;

		public UserModel build() {
			final UserModel userModel = new UserModel();
			userModel.userId = userId;
			userModel.userName = userName;
			userModel.password = password;
			userModel.firstName = firstName;
			userModel.lastName = lastName;
			userModel.country = country;
			userModel.age = age;
			userModel.email = email;
			return userModel;
		}

		public Builder withAge(final Integer age) {
			this.age = age;
			return this;
		}

		public Builder withCountry(final String country) {
			this.country = country;
			return this;
		}

		public Builder withEmail(final String email) {
			this.email = email;
			return this;
		}

		public Builder withFirstName(final String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(final String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withPassword(final String password) {
			this.password = password;
			return this;
		}

		public Builder withUserId(final String userId) {
			this.userId = userId;
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

	@JsonProperty
	private String userId;

	@NotBlank
	@JsonProperty
	private String userName;

	@NotBlank
	@JsonProperty
	private String password;

	@NotBlank
	@JsonProperty
	private String firstName;

	@NotBlank
	@JsonProperty
	private String lastName;

	@NotBlank
	@JsonProperty
	private String country;

	@Min(12)
	@JsonProperty
	private Integer age;

	@NotBlank
	@Email
	@JsonProperty
	private String email;

	public Integer getAge() {
		return age;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}
}
