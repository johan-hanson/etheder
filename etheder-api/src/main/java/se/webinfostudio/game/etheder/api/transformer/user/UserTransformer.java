package se.webinfostudio.game.etheder.api.transformer.user;

import static java.util.UUID.fromString;
import static org.mindrot.jbcrypt.BCrypt.gensalt;
import static org.mindrot.jbcrypt.BCrypt.hashpw;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.entity.player.Login;
import se.webinfostudio.game.etheder.entity.player.User;

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
		user.getLogin().setPasswordHash(hashpw(userModel.getPassword(), gensalt(12)));
		user.getLogin().setUser(user.toRef());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setCountry(userModel.getCountry());
		user.setAge(userModel.getAge());
		user.setEmail(userModel.getEmail());
		return user;
	}
}
