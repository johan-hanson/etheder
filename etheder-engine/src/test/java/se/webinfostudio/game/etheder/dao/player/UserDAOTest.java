package se.webinfostudio.game.etheder.dao.player;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.buildUser;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class UserDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(User.class)
			.addEntityClass(Login.class)
			.build();

	private UserDAO sut;

	@Before
	public void before() {
		sut = new UserDAO(database.getSessionFactory());
	}

	@Test
	public void findById() {
		final User user = createUser();
		sut.persist(user);
		final Optional<User> result = sut.findById(user.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getLogin()).isNotNull();
		assertThat(result.get().getId()).isEqualTo(user.getId());
	}

	@Test
	public void findByToken_shouldThrowNoResultException_whenUserNotFound() {
		assertThatThrownBy(() -> sut.findByToken(randomUUID())).isInstanceOf(NoResultException.class);
	}

	@Test
	public void findByUserName() {
		final String userName = "userName";
		final User user = buildUser()
				.withUserName(userName)
				.build();
		final User result = database.inTransaction(() -> {
			sut.persist(user);
			return sut.findByUserName(userName);
		});

		assertThat(result.getLogin().getUserName()).isEqualTo(user.getLogin().getUserName());
	}

	@Test
	public void findByUserName_shouldThrowNoResultException_whenUserNotFound() {
		assertThatThrownBy(() -> sut.findByUserName("userName")).isInstanceOf(NoResultException.class);
	}

	@Test
	public void findToken() {
		final UUID token = randomUUID();
		final User user = buildUser()
				.withToken(token)
				.build();
		final User result = database.inTransaction(() -> {
			sut.persist(user);
			return sut.findByToken(token);
		});

		assertThat(result.getLogin().getUserName()).isEqualTo(user.getLogin().getUserName());
	}

	@Test
	public void persist() {
		final User user = createUser();
		final User result = sut.persist(user);

		assertThat(result.getId()).isEqualTo(user.getId());
	}

}
