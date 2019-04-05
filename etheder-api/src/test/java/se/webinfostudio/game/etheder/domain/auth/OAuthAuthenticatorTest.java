package se.webinfostudio.game.etheder.domain.auth;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import io.dropwizard.auth.AuthenticationException;
import se.webinfostudio.game.etheder.dao.user.UserDAO;
import se.webinfostudio.game.etheder.entity.user.User;

public class OAuthAuthenticatorTest {

	private OAuthAuthenticator sut;

	@Mock
	private UserDAO userDAO;

	@BeforeEach
	protected void setUp() {
		initMocks(this);

		sut = new OAuthAuthenticator(userDAO);
	}

	@Test
	void authenticate() throws AuthenticationException {
		final UUID token = randomUUID();
		final User user = createUser();
		when(userDAO.findByToken(token)).thenReturn(of(user));

		final Optional<AuthUser> result = sut.authenticate(token.toString());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getUserId()).isEqualTo(user.getId().toString());
		assertThat(result.get().getUserName()).isEqualTo(user.getLogin().getUserName());
		assertThat(result.get().getFirstName()).isEqualTo(user.getFirstName());
		assertThat(result.get().getLastName()).isEqualTo(user.getLastName());
	}

	@Test
	void authenticate_shouldReturnEmpty_whenUserNotFoundInDb() throws AuthenticationException {
		final UUID token = randomUUID();
		when(userDAO.findByToken(token)).thenReturn(empty());

		final Optional<AuthUser> result = sut.authenticate(token.toString());

		assertThat(result.isPresent()).isFalse();
	}
}
