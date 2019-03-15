package se.webinfostudio.game.etheder.dao.player;

import static java.util.Optional.ofNullable;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.player.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserDAO extends AbstractDAO<User> {

	@Inject
	public UserDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public User create(final User user) {
		super.currentSession().persist(user.getLogin());
		return super.persist(user);
	}

	public Optional<User> findById(final UUID id) {
		return ofNullable(super.get(id));
	}

	public Optional<User> findByUserName(final String userName) {
		return ofNullable(super.query("SELECT u FROM User u WHERE u.login.userName=?un").setParameter("un", userName)
				.getSingleResult());
	}

	@Override
	public User persist(final User user) {
		return super.persist(user);
	}
}
