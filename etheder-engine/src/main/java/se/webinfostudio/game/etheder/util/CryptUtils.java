package se.webinfostudio.game.etheder.util;

import static org.mindrot.jbcrypt.BCrypt.checkpw;
import static org.mindrot.jbcrypt.BCrypt.gensalt;
import static org.mindrot.jbcrypt.BCrypt.hashpw;

/**
 * Wrapper class to handel the crypt of passwords.
 *
 * @author Johan Hanson
 *
 */
public final class CryptUtils {

	public static boolean checkPassword(final String password, final String hashed) {
		return checkpw(password, hashed);
	}

	public static String hashPassword(final String password) {
		return hashpw(password, gensalt(12));
	}

	private CryptUtils() {
		// not used
	}
}
