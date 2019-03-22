package se.webinfostudio.game.etheder.entity.util;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

import java.time.LocalDateTime;
import java.util.UUID;

import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserTestFactory {

	public static final class Builder {

		private UUID userId = randomUUID();
		private String userName = "slayer";
		private String password = "password";
		private String firstName = "Johan";
		private String lastName = "Hanson";
		private String country = "Sweden";
		private Integer age = 40;
		private String email = "user@example.org";
		private UUID token = randomUUID();
		private LocalDateTime tokenExpireDate = now();

		public User build() {
			final User user = new User();
			user.setId(userId);
			user.setLogin(new Login());
			user.getLogin().setUserName(userName);
			user.getLogin().setPasswordHash(password);
			user.getLogin().setToken(token);
			user.getLogin().setTokenExpireDate(tokenExpireDate);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setCountry(country);
			user.setAge(age);
			user.setEmail(email);
			return user;
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

		public Builder withToken(final UUID token) {
			this.token = token;
			return this;
		}

		public Builder withTokenExpireDate(final LocalDateTime tokenExpireDate) {
			this.tokenExpireDate = tokenExpireDate;
			return this;
		}

		public Builder withUserId(final UUID userId) {
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

	private UserTestFactory() {
		// not used
	}
}
