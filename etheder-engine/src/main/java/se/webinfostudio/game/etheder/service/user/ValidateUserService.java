package se.webinfostudio.game.etheder.service.user;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.exception.user.UserValidationException;
import se.webinfostudio.game.etheder.repository.user.LoginRepository;
import se.webinfostudio.game.etheder.repository.user.UserRepository;

/**
 * Validate an {@link User} before saving the {@link User} to database.
 *
 * @author Johan Hanson
 *
 */
public class ValidateUserService {

	private final LoginRepository loginRepository;

	private final UserRepository userRepository;

	@Inject
	public ValidateUserService(final LoginRepository loginRepository, final UserRepository userRepository) {
		this.loginRepository = loginRepository;
		this.userRepository = userRepository;
	}

	public void validateNewUser(final Login login, final User user) {
		if (checkIfUserNameExist(login.getUserName())) {
			throw new UserValidationException("UserName already exist");
		}
		if (checkIfEmailExist(user.getEmail())) {
			throw new UserValidationException("Email already exist");
		}
	}

	private boolean checkIfEmailExist(final String email) {
		return userRepository.findByEmail(email).isPresent();
	}

	private boolean checkIfUserNameExist(final String userName) {
		return loginRepository.findByUserName(userName).isPresent();
	}
}
