package se.webinfostudio.game.etheder.entity.util;

import static java.util.UUID.randomUUID;

import java.util.UUID;

import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserTestFactory {

	public static final class Builder {

		private UUID userId = randomUUID();
		private String firstName = "Johan";
		private String lastName = "Hanson";
		private String country = "Sweden";
		private Integer age = 40;
		private String email = "user@example.org";

		public User build() {
			final User user = new User();
			user.setId(userId);
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

		public Builder withUserId(final UUID userId) {
			this.userId = userId;
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
