package se.webinfostudio.game.etheder.exception.user;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserValidationException extends RuntimeException {

	private static final long serialVersionUID = 2781300253717486175L;

	public UserValidationException() {
		super();
	}

	public UserValidationException(final String message) {
		super(message);
	}
}
