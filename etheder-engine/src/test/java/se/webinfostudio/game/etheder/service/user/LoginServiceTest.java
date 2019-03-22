package se.webinfostudio.game.etheder.service.user;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.buildUser;
import static se.webinfostudio.game.etheder.util.CryptUtils.hashPassword;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.user.UserDAO;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;

public class LoginServiceTest {

	private LoginService sut;

	@Mock
	private UserDAO userDAO;

	private final String userName = "userName";
	private final String password = "password";

	@BeforeEach
	void beforeEach() {
		initMocks(this);

		sut = new LoginService(userDAO);
	}

	@Test
	void login() {
		final Login login = new Login();
		login.setUserName(userName);
		login.setPasswordHash(password);

		final User user = buildUser()
				.withUserName(userName)
				.withPassword(hashPassword(password))
				.build();

		when(userDAO.findByUserName(userName)).thenReturn(of(user));

		final Optional<Login> result = sut.login(login);

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getToken()).isNotNull();
		assertThat(result.get().getTokenExpireDate()).isNotNull();
	}

	@Test
	void login_shouldReturnEmpty_whenPasswordIsIncorrect() {
		final Login login = new Login();
		login.setUserName(userName);
		login.setPasswordHash("badpassword");

		final User user = buildUser()
				.withUserName(userName)
				.withPassword(hashPassword(password))
				.build();

		when(userDAO.findByUserName(userName)).thenReturn(of(user));

		final Optional<Login> result = sut.login(login);

		assertThat(result.isPresent()).isFalse();
	}
}
