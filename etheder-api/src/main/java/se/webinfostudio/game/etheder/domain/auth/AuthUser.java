package se.webinfostudio.game.etheder.domain.auth;

import static java.lang.String.format;

import java.security.Principal;
import java.util.List;

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
		private String userName;

		public AuthUser build() {
			final AuthUser authUser = new AuthUser();
			authUser.roles = roles;
			authUser.firstName = firstName;
			authUser.lastName = lastName;
			authUser.userName = userName;
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
	private String userName;

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getName() {
		return format("%s %s", firstName, lastName);
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
