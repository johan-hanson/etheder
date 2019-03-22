package se.webinfostudio.game.etheder.service.user;

import static java.time.LocalDateTime.now;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static se.webinfostudio.game.etheder.util.CryptUtils.checkPassword;

import java.util.Optional;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.dao.user.UserDAO;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class LoginService {

	private final UserDAO userDAO;

	@Inject
	public LoginService(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Optional<Login> login(final Login login) {
		final Optional<User> user = userDAO.findByUserName(login.getUserName());
		if (!user.isPresent()) {
			return empty();
		}
		final Login loginDb = user.get().getLogin();
		if (checkPassword(login.getPasswordHash(), loginDb.getPasswordHash())) {
			loginDb.setToken(randomUUID());
			loginDb.setTokenExpireDate(now().plusHours(1L));
			userDAO.persist(user.get());
			return of(loginDb);
		}
		return empty();
	}

}
