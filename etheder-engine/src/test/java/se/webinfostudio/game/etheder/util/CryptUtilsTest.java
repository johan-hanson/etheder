package se.webinfostudio.game.etheder.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CryptUtilsTest {

	@Nested
	class checkPassword {

		@Test
		void happyflow() {
			assertThat(CryptUtils.checkPassword("hanjo1234", CryptUtils.hashPassword("hanjo1234"))).isTrue();
		}

		@Test
		void badPassword() {
			assertThat(CryptUtils.checkPassword("badPassword", CryptUtils.hashPassword("hanjo1234"))).isFalse();
		}

		@Test
		void dbTest() {
			assertThat(CryptUtils.checkPassword("qwerty1234",
					"$2a$12$rlrFy7NNhNyEhH0FtGQjTuxCe4TuIkLkk40ngPZvLU9AapIrUJVFK")).isFalse();
		}
	}

	@Test
	void hashPassword() {
		assertThat(CryptUtils.hashPassword("hanjo1234")).isNotNull();
	}
}
