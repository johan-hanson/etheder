package se.webinfostudio.game.etheder.domain.auth;

/**
 *
 * @author Johan Hanson
 *
 */
public class Credentials {

	private final String token;

	public Credentials(final String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
