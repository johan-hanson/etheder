package se.webinfostudio.game.etheder.api.transformer.user;

import static java.util.UUID.fromString;
import static se.webinfostudio.game.etheder.util.CryptUtils.hashPassword;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserTransformer implements Function<UserModel, User> {

	@Override
	public User apply(final UserModel userModel) {
		final User user = new User();
		if (userModel.getUserId() != null) {
			user.setId(fromString(userModel.getUserId()));
		}
		user.setLogin(new Login());
		user.getLogin().setUserName(userModel.getUserName());
		user.getLogin().setPasswordHash(hashPassword(userModel.getPassword()));
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setCountry(userModel.getCountry());
		user.setAge(userModel.getAge());
		user.setEmail(userModel.getEmail());
		return user;
	}
}
