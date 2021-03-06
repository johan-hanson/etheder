package se.webinfostudio.game.etheder.domain.auth;

import static java.lang.String.format;
import static java.util.UUID.fromString;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Johan Hanson
 *
 */
public class AuthUser implements Principal {

	public static class Builder {
		private List<String> roles;
		private String firstName;
		private String lastName;
		private String userId;
		private String userName;

		public AuthUser build() {
			final AuthUser authUser = new AuthUser();
			authUser.roles = roles;
			authUser.firstName = firstName;
			authUser.lastName = lastName;
			authUser.userName = userName;
			authUser.userId = userId;
			return authUser;
		}

		public Builder withFirstName(final String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(final String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withRoles(final List<String> roles) {
			this.roles = roles;
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

	private List<String> roles;

	private String firstName;
	private String lastName;
	private String userId;
	private String userName;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String getName() {
		return format("%s %s", firstName, lastName);
	}

	public String getUserId() {
		return userId;
	}

	public UUID getUserIdAsUUID() {
		return fromString(userId);
	}

	public String getUserName() {
		return userName;
	}

	public boolean hasRole(final String role) {
		if (roles == null) {
			return false;
		}
		return roles.contains(role);
	}
}
