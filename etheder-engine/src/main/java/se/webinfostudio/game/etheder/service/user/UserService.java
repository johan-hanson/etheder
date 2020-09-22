package se.webinfostudio.game.etheder.service.user;

import static se.webinfostudio.game.etheder.util.BeanValidationUtils.validate;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.dao.user.UserDAO;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.repository.user.LoginRepository;
import se.webinfostudio.game.etheder.repository.user.UserRepository;

/**
 *
 * @author Johan Hanson
 */
@Named
public class UserService {

	private final UserDAO userDAO;

	private final LoginRepository loginRepository;

	private final UserRepository userRepository;

	private final ValidateUserService validateUserService;

	@Inject
	public UserService(
			final UserDAO userDAO,
			final LoginRepository loginRepository,
			final UserRepository userRepository,
			final ValidateUserService validateUserService) {
		this.userDAO = userDAO;
		this.loginRepository = loginRepository;
		this.userRepository = userRepository;
		this.validateUserService = validateUserService;
	}

	@InTransaction
	public User createUser(final Login login, final User user) {
		validate(login);
		validate(user);

		validateUserService.validateNewUser(login, user);

		// validate password in transformer

		loginRepository.create(login);
		user.setLoginId(login.getId());
		userRepository.create(user);

		return user;
	}

	public void updatePassword(final String userName, final String oldPassword, final String newPassword) {
		// validate new password
		// validate old password is correct

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
