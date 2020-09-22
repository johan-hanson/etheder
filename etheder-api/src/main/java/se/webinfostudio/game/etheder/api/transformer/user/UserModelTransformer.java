package se.webinfostudio.game.etheder.api.transformer.user;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserModelTransformer implements Function<User, UserModel> {

	@Override
	public UserModel apply(final User user) {
		return UserModel.newBuilder()
				.withUserId(user.getId().toString())
				.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withAge(user.getAge())
				.withCountry(user.getCountry())
				.withEmail(user.getEmail())
				.build();
	}

}
