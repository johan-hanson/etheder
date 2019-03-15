package se.webinfostudio.game.etheder.service.player;

import static se.webinfostudio.game.etheder.util.BeanValidationUtils.validate;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.player.UserDAO;
import se.webinfostudio.game.etheder.entity.player.User;

/**
 *
 * @author Johan Hanson
 */
@Named
public class UserService {

	private final UserDAO userDAO;

	@Inject
	public UserService(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User createUser(final User user) {
		validate(user);

		// validation against db, if username already exist, email already exist

		return userDAO.create(user);
	}

	public void updatePassword(final String oldPassword, final String newPassword) {
//		final Optional<User> persistedUser = userDAO.findById(user.getId());
//		if (persistedUser.isPresent()) {
//
//		}
	}

	public User updateUser(final User user) {
		// validation...
		final Optional<User> persistedUser = userDAO.findById(user.getId());
		if (persistedUser.isPresent()) {
			updateUser(persistedUser.get(), user);
			return userDAO.persist(persistedUser.get());
		}
		throw new IllegalArgumentException("User could not be found");
	}

	private void updateUser(final User userToPersist, final User userToCopyFrom) {
		userToPersist.setFirstName(userToCopyFrom.getFirstName());
		userToPersist.setLastName(userToCopyFrom.getLastName());
	}
}
