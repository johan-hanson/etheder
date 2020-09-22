package se.webinfostudio.game.etheder.entity.util;

import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;

import java.time.LocalDateTime;
import java.util.UUID;

import se.webinfostudio.game.etheder.entity.user.Login;

public class LoginTestFactory {

	public static final class Builder {

		private UUID loginId = randomUUID();
		private String userName = "slayer";
		private String password = "password";
		private UUID token = randomUUID();
		private LocalDateTime tokenExpireDate = now();

		public Login build() {
			final Login login = new Login();
			login.setId(loginId);
			login.setUserName(userName);
			login.setPasswordHash(password);
			login.setToken(token);
			login.setTokenExpireDate(tokenExpireDate);
			return login;
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

		public Builder withLoginId(final UUID loginId) {
			this.loginId = loginId;
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

	private LoginTestFactory() {
		// not used
	}
}
