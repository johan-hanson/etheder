package se.webinfostudio.game.etheder.dao.player;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.entity.player.User;

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
		assertThat(result.get().getId()).isEqualTo(user.getId());
	}

	@Test
	public void persist() {
		final User user = createUser();
		final User result = sut.persist(user);

		assertThat(result.getId()).isEqualTo(user.getId());
	}

}
