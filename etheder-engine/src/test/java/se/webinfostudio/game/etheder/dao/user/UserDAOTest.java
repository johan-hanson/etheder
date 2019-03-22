package se.webinfostudio.game.etheder.dao.user;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.buildUser;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class UserDAOTest {

	DAOTestExtension daoTestExtension = DAOTestExtension.newBuilder()
			.addEntityClass(User.class)
			.addEntityClass(Login.class)
			.build();

	private UserDAO sut;

	private final String userName = "userName";

	@BeforeEach
	void before() {
		sut = new UserDAO(daoTestExtension.getSessionFactory());
	}

	@Test
	void findByEmail() {
		final User user = buildUser()
				.withEmail("test@example.org")
				.build();
		final Optional<User> result = daoTestExtension.inTransaction(() -> {
			sut.persist(user);
			return sut.findByEmail("test@example.org");
		});

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getEmail()).isEqualTo(user.getEmail());
	}

	@Test
	void findByEmail_shouldReturnEmpty_whenUserNotFound() {
		final Optional<User> result = daoTestExtension.inTransaction(() -> {
			return sut.findByEmail("test@example.org");
		});

		assertThat(result.isPresent()).isFalse();
	}

	@Test
	void findById() {
		final User user = createUser();
		sut.persist(user);
		final Optional<User> result = sut.findById(user.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getLogin()).isNotNull();
		assertThat(result.get().getId()).isEqualTo(user.getId());
	}

	@Test
	void findByToken_shouldReturnEmpty_whenUserNotFound() {
		final Optional<User> result = daoTestExtension.inTransaction(() -> {
			return sut.findByToken(randomUUID());
		});

		assertThat(result.isPresent()).isFalse();
	}

	@Test
	void findByUserName() {
		final User user = buildUser()
				.withUserName(userName)
				.build();
		final Optional<User> result = daoTestExtension.inTransaction(() -> {
			sut.persist(user);
			return sut.findByUserName(userName);
		});

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getLogin().getUserName()).isEqualTo(user.getLogin().getUserName());
	}

	@Test
	void findByUserName_shouldReturnEmpty_whenUserNotFound() {
		final Optional<User> result = daoTestExtension.inTransaction(() -> {
			return sut.findByUserName(userName);
		});

		assertThat(result.isPresent()).isFalse();
	}

	@Test
	void findToken() {
		final UUID token = randomUUID();
		final User user = buildUser()
				.withToken(token)
				.build();
		final Optional<User> result = daoTestExtension.inTransaction(() -> {
			sut.persist(user);
			return sut.findByToken(token);
		});

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getLogin().getUserName()).isEqualTo(user.getLogin().getUserName());
	}

	@Test
	void persist() {
		final User user = createUser();
		final User result = sut.persist(user);

		assertThat(result.getId()).isEqualTo(user.getId());
	}

}
