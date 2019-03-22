package se.webinfostudio.game.etheder.service.user;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.buildUser;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.user.UserDAO;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.service.user.UserService;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserServiceTest {

	@InjectMocks
	private UserService sut;

	@Mock
	private UserDAO userDAO;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
	}

	@Test
	void createUser_ok() {
		final User user = createUser();

		sut.createUser(user);

		verify(userDAO).persist(user);
	}

	@Test
	void updatePassword() {
		sut.updatePassword("userName", "old", "new");
	}

	@Test
	void updateUser() {
		final User user = createUser();
		final User userDb = buildUser()
				.withFirstName("Erik")
				.withLastName("Svensson")
				.build();

		when(userDAO.findById(user.getId())).thenReturn(of(userDb));

		sut.updateUser(user);

		assertThat(user.getFirstName()).isEqualTo(userDb.getFirstName());
		assertThat(user.getLastName()).isEqualTo(userDb.getLastName());

		verify(userDAO).persist(userDb);
	}

	@Test
	void updateUser_shouldThrowIllegalArgumentException_whenUserNotFound() {
		final User user = createUser();
		when(userDAO.findById(user.getId())).thenReturn(empty());

		assertThatThrownBy(() -> sut.updateUser(user))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("User could not be found");

		verify(userDAO, never()).persist(any(User.class));
	}
}
