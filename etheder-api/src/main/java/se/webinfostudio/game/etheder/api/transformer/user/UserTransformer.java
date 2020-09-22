package se.webinfostudio.game.etheder.api.transformer.user;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.user.UserModel;
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
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setCountry(userModel.getCountry());
		user.setAge(userModel.getAge());
		user.setEmail(userModel.getEmail());
		return user;
	}
}
