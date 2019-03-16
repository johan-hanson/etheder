package se.webinfostudio.game.etheder.api.transformer.user;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.user.LoginModel;
import se.webinfostudio.game.etheder.entity.user.Login;

/**
 *
 * @author Johan Hanson
 *
 */
public class LoginTransformer implements Function<LoginModel, Login> {

	@Override
	public Login apply(final LoginModel loginModel) {
		final Login login = new Login();
		login.setUserName(loginModel.getUserName());
		login.setPasswordHash(loginModel.getPassword());
		return login;
	}

}
