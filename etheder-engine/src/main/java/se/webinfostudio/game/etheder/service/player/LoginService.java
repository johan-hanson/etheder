package se.webinfostudio.game.etheder.service.player;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.mindrot.jbcrypt.BCrypt.checkpw;

import java.util.Date;
import java.util.Optional;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.dao.player.UserDAO;
import se.webinfostudio.game.etheder.entity.player.Login;
import se.webinfostudio.game.etheder.entity.player.User;

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
		final Optional<User> userOpt = userDAO.findByUserName(login.getUserName());
		if (userOpt.isPresent()) {
			final Login loginDb = userOpt.get().getLogin();
			if (checkpw(login.getPasswordHash(), loginDb.getPasswordHash())) {
				loginDb.setToken(randomUUID());
				loginDb.setTokenExpireDate(new Date());
				userDAO.persist(userOpt.get());
				return of(loginDb);
			}
		}
		return empty();
	}

}
