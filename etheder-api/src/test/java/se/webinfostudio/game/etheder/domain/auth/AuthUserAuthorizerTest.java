package se.webinfostudio.game.etheder.domain.auth;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthUserAuthorizerTest {

	private AuthUserAuthorizer sut;

	private AuthUser authUser;

	@Test
	void authorizeNotOk() {
		assertThat(sut.authorize(authUser, "C")).isFalse();
	}

	@Test
	void authorizeOk() {
		assertThat(sut.authorize(authUser, "B")).isTrue();
	}

	@BeforeEach
	void beforeEach() {
		sut = new AuthUserAuthorizer();
		authUser = AuthUser.newBuilder()
				.withRoles(asList("A", "B"))
				.build();
	}
}
