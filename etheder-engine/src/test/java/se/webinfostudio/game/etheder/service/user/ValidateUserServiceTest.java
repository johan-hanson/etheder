package se.webinfostudio.game.etheder.service.user;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.buildLogin;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.buildUser;
import static se.webinfostudio.game.etheder.test.TestConstants.EMAIL;
import static se.webinfostudio.game.etheder.test.TestConstants.USERNAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.exception.user.UserValidationException;
import se.webinfostudio.game.etheder.repository.user.LoginRepository;
import se.webinfostudio.game.etheder.repository.user.UserRepository;

public class ValidateUserServiceTest {

	private ValidateUserService sut;

	@Mock
	private LoginRepository loginRepository;

	@Mock
	private UserRepository userRepository;

	private Login login;
	private User user;

	@BeforeEach
	void beforeEach() {
		initMocks(this);

		login = buildLogin()
				.withUserName(USERNAME)
				.build();
		user = buildUser()
				.withEmail(EMAIL)
				.build();

		sut = new ValidateUserService(loginRepository, userRepository);
	}

	@Test
	void validateNewUser() {
		sut.validateNewUser(login, user);

		verify(loginRepository).findByUserName(USERNAME);
		verify(userRepository).findByEmail(EMAIL);
	}

	@Test
	void validateNewUser_shouldThrowUserValidationException_whenUserWithEmailFoundInDatabase() {
		when(userRepository.findByEmail(EMAIL)).thenReturn(of(user));

		assertThatThrownBy(() -> sut.validateNewUser(login, user))
				.isInstanceOf(UserValidationException.class);

		verify(userRepository).findByEmail(EMAIL);
	}

	@Test
	void validateNewUser_shouldThrowUserValidationException_whenUserWithUserNameFoundInDatabase() {
		when(loginRepository.findByUserName(USERNAME)).thenReturn(of(login));

		assertThatThrownBy(() -> sut.validateNewUser(login, user))
				.isInstanceOf(UserValidationException.class);

		verify(loginRepository).findByUserName(USERNAME);
	}

}
