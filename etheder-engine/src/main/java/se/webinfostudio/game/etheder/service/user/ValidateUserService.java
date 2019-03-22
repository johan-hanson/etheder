package se.webinfostudio.game.etheder.service.user;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.dao.user.UserDAO;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.exception.user.UserValidationException;

/**
 * Validate an {@link User} before saving the {@link User} to database.
 *
 * @author Johan Hanson
 *
 */
public class ValidateUserService {

	private final UserDAO userDAO;

	@Inject
	public ValidateUserService(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void validateNewUser(final User user) {
		if (checkIfUserNameExist(user.getLogin().getUserName())) {
			throw new UserValidationException("UserName already exist");
		}
		if (checkIfEmailExist(user.getEmail())) {
			throw new UserValidationException("Email already exist");
		}
	}

	private boolean checkIfEmailExist(final String email) {
		return userDAO.findByEmail(email).isPresent();
	}

	private boolean checkIfUserNameExist(final String userName) {
		return userDAO.findByUserName(userName).isPresent();
	}
}
