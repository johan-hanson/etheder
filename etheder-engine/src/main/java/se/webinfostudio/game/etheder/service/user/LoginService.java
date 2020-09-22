package se.webinfostudio.game.etheder.service.user;

import static java.time.LocalDateTime.now;
import static java.util.Optional.empty;
import static java.util.UUID.randomUUID;
import static se.webinfostudio.game.etheder.util.CryptUtils.checkPassword;

import java.util.Optional;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.repository.user.LoginRepository;

/**
 *
 * @author Johan Hanson
 *
 */
public class LoginService {

	private final LoginRepository loginRepository;

	@Inject
	public LoginService(final LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public Optional<Login> login(final Login login) {
		final Optional<Login> loginDb = loginRepository.findByUserName(login.getUserName());
		if (!loginDb.isPresent()) {
			return empty();
		}
		if (checkPassword(login.getPasswordHash(), loginDb.get().getPasswordHash())) {
			loginDb.get().setToken(randomUUID());
			loginDb.get().setTokenExpireDate(now().plusHours(1L));
			loginRepository.updateToken(loginDb.get());
			return loginDb;
		}
		return empty();
	}

}
