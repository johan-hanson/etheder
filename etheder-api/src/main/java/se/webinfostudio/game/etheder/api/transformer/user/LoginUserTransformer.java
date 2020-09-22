package se.webinfostudio.game.etheder.api.transformer.user;

import static se.webinfostudio.game.etheder.util.CryptUtils.hashPassword;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.entity.user.Login;

/**
 *
 * For register user with user name and password
 *
 * @author Johan Hanson
 *
 */
public class LoginUserTransformer implements Function<UserModel, Login> {

	@Override
	public Login apply(final UserModel userModel) {
		final Login login = new Login();
		login.setUserName(userModel.getUserName());
		// TODO: validation!!
		login.setPasswordHash(hashPassword(userModel.getPassword()));
		return login;
	}
}
