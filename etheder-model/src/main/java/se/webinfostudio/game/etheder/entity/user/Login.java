package se.webinfostudio.game.etheder.entity.user;

import java.time.LocalDateTime;
import java.util.UUID;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;

/**
 *
 * @author Johan Hanson
 *
 */
public class Login extends AbstractGameEntity {

	private static final long serialVersionUID = 5301118324148225272L;

	private String userName;
	private String passwordHash;
	private UUID token;
	private LocalDateTime tokenExpireDate;

	public String getPasswordHash() {
		return passwordHash;
	}

	public UUID getToken() {
		return token;
	}

	public LocalDateTime getTokenExpireDate() {
		return tokenExpireDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setPasswordHash(final String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setToken(final UUID token) {
		this.token = token;
	}

	public void setTokenExpireDate(final LocalDateTime tokenExpireDate) {
		this.tokenExpireDate = tokenExpireDate;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}
}
