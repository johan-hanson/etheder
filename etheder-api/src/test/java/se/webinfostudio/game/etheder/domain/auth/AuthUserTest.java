package se.webinfostudio.game.etheder.domain.auth;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AuthUserTest {

	@Test
	void getName() {
		final AuthUser sut = AuthUser.newBuilder()
				.withFirstName("Johan")
				.withLastName("Hanson")
				.build();
		assertThat(sut.getName()).isEqualTo("Johan Hanson");
	}

	@Test
	void hasRoleFalse() {
		final AuthUser sut = AuthUser.newBuilder()
				.withRoles(asList("A", "B"))
				.build();
		assertThat(sut.hasRole("C")).isFalse();
	}

	@Test
	void hasRoleTrue() {
		final AuthUser sut = AuthUser.newBuilder()
				.withRoles(asList("A", "B"))
				.build();
		assertThat(sut.hasRole("A")).isTrue();
	}
}
