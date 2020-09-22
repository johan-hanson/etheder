package se.webinfostudio.game.etheder.domain.auth;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import io.dropwizard.auth.AuthenticationException;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.repository.user.LoginRepository;
import se.webinfostudio.game.etheder.repository.user.UserRepository;

public class OAuthAuthenticatorTest {

	private OAuthAuthenticator sut;

	@Mock
	private LoginRepository loginRepository;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	protected void setUp() {
		initMocks(this);

		sut = new OAuthAuthenticator(loginRepository, userRepository);
	}

	@Test
	void authenticate() throws AuthenticationException {
		final UUID token = randomUUID();
		final Login login = new Login();
		login.setUserName("slayer");
		final User user = createUser();
		when(loginRepository.findByToken(token)).thenReturn(of(login));
		when(userRepository.findByLoginId(any(UUID.class))).thenReturn(user);

		final Optional<AuthUser> result = sut.authenticate(token.toString());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getUserId()).isEqualTo(user.getId().toString());
		assertThat(result.get().getUserName()).isEqualTo(login.getUserName());
		assertThat(result.get().getFirstName()).isEqualTo(user.getFirstName());
		assertThat(result.get().getLastName()).isEqualTo(user.getLastName());
	}

	@Test
	void authenticate_shouldReturnEmpty_whenUserNotFoundInDb() throws AuthenticationException {
		final UUID token = randomUUID();
		when(loginRepository.findByToken(token)).thenReturn(empty());

		final Optional<AuthUser> result = sut.authenticate(token.toString());

		assertThat(result.isPresent()).isFalse();
	}
}
