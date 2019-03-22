package se.webinfostudio.game.etheder.service.user;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.test.TestConstants.EMAIL;
import static se.webinfostudio.game.etheder.test.TestConstants.USERNAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.user.UserDAO;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.entity.util.EntityTestFactory;
import se.webinfostudio.game.etheder.exception.user.UserValidationException;

public class ValidateUserServiceTest {

	private ValidateUserService sut;

	@Mock
	private UserDAO userDAO;

	private User user;

	@BeforeEach
	void beforeEach() {
		initMocks(this);

		user = EntityTestFactory.buildUser()
				.withEmail(EMAIL)
				.withUserName(USERNAME)
				.build();

		sut = new ValidateUserService(userDAO);
	}

	@Test
	void validateNewUser() {
		sut.validateNewUser(user);

		verify(userDAO).findByEmail(EMAIL);
		verify(userDAO).findByUserName(USERNAME);
	}

	@Test
	void validateNewUser_shouldThrowUserValidationException_whenUserWithEmailFoundInDatabase() {
		when(userDAO.findByEmail(EMAIL)).thenReturn(of(user));

		assertThatThrownBy(() -> sut.validateNewUser(user))
				.isInstanceOf(UserValidationException.class);

		verify(userDAO).findByEmail(EMAIL);
		verify(userDAO).findByUserName(USERNAME);
	}

	@Test
	void validateNewUser_shouldThrowUserValidationException_whenUserWithUserNameFoundInDatabase() {
		when(userDAO.findByUserName(USERNAME)).thenReturn(of(user));

		assertThatThrownBy(() -> sut.validateNewUser(user))
				.isInstanceOf(UserValidationException.class);

		verify(userDAO, never()).findByEmail(EMAIL);
		verify(userDAO).findByUserName(USERNAME);
	}
}
