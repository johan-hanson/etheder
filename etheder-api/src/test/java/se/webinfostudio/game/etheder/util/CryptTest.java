package se.webinfostudio.game.etheder.util;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class CryptTest {

	@Test
	void testBCrypt() {
		final String password = "qwerty1234";

		final String salt = BCrypt.gensalt();
		final String hashed = BCrypt.hashpw(salt + password, BCrypt.gensalt(12));

		System.out.println("Password : " + password);
		System.out.println("hashed : " + hashed);
		System.out.println("hashed : " + hashed.length());

		if (BCrypt.checkpw(salt + password, hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
	}
}
