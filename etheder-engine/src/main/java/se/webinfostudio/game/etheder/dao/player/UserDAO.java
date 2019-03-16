package se.webinfostudio.game.etheder.dao.player;

import static java.util.Optional.ofNullable;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.user.User;

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

	public Optional<User> findById(final UUID id) {
		return ofNullable(super.get(id));
	}

	/**
	 * Find an {@link User} by its token.
	 *
	 * @param token token for the user to find
	 * @return {@link User} if found else throws NoResultException
	 */
	public User findByToken(final UUID token) {
		return super.query("SELECT u FROM User u WHERE u.login.token=:t")
				.setParameter("t", token)
				.getSingleResult();
	}

	/**
	 * Find an {@link User} by its userName.
	 *
	 * @param userName userName on user to find
	 * @return {@link User} if found else throws NoResultException
	 */
	public User findByUserName(final String userName) {
		return super.query("SELECT u FROM User u WHERE u.login.userName=:un")
				.setParameter("un", userName)
				.getSingleResult();
	}

	@Override
	public User persist(final User user) {
		return super.persist(user);
	}
}
