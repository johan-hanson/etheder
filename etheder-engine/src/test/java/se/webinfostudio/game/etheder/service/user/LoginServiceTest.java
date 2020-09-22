package se.webinfostudio.game.etheder.service.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.buildLogin;
import static se.webinfostudio.game.etheder.util.CryptUtils.hashPassword;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.repository.user.LoginRepository;

public class LoginServiceTest {

	private LoginService sut;

	@Mock
	private LoginRepository loginRepository;

	private final String userName = "userName";
	private final String password = "password";

	@BeforeEach
	void beforeEach() {
		initMocks(this);

		sut = new LoginService(loginRepository);
	}

	@Test
	void login() {
		final Login login = buildLogin()
				.withUserName(userName)
				.withPassword(password)
				.build();
		final Login loginDb = buildLogin()
				.withUserName(userName)
				.withPassword(hashPassword(password))
				.build();

		when(loginRepository.findByUserName(userName)).thenReturn(Optional.of(loginDb));

		final Optional<Login> result = sut.login(login);

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getToken()).isNotNull();
		assertThat(result.get().getTokenExpireDate()).isNotNull();
	}

	@Test
	void login_shouldReturnEmpty_whenPasswordIsIncorrect() {
		final Login login = buildLogin()
				.withUserName(userName)
				.withPassword("badPassword")
				.build();
		final Login loginDb = buildLogin()
				.withUserName(userName)
				.withPassword(hashPassword(password))
				.build();

		when(loginRepository.findByUserName(userName)).thenReturn(Optional.of(loginDb));

		final Optional<Login> result = sut.login(login);

		assertThat(result.isPresent()).isFalse();
	}

	@Test
	void login_shouldReturnEmpty_whenNoUserFound() {
		final Login login = buildLogin()
				.withUserName(userName)
				.withPassword("badPassword")
				.build();

		final Optional<Login> result = sut.login(login);

		assertThat(result.isPresent()).isFalse();
	}
}
