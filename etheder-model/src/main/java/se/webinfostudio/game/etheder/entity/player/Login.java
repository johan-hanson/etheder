package se.webinfostudio.game.etheder.entity.player;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;

/**
 *
 * @author Johan Hanson
 *
 */
@Entity(name = "Logins")
public class Login extends AbstractGameEntity {

	private static final long serialVersionUID = 5301118324148225272L;

	@Column(nullable = false, unique = true)
	private String userName;
	private String passwordHash;
	private UUID token;
	@Temporal(TemporalType.TIMESTAMP)
	private Date tokenExpireDate;
	private UserRef user;

	public String getPasswordHash() {
		return passwordHash;
	}

	public UUID getToken() {
		return token;
	}

	public Date getTokenExpireDate() {
		return tokenExpireDate;
	}

	public UserRef getUser() {
		return user;
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

	public void setTokenExpireDate(final Date tokenExpireDate) {
		this.tokenExpireDate = tokenExpireDate;
	}

	public void setUser(final UserRef user) {
		this.user = user;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}
}
