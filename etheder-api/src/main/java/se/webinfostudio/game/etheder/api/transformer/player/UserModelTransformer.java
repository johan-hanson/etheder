package se.webinfostudio.game.etheder.api.transformer.player;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.player.UserModel;
import se.webinfostudio.game.etheder.entity.player.User;

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
				.withUserName(user.getLogin().getUserName())
				.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withAge(user.getAge())
				.withCountry(user.getCountry())
				.withEmail(user.getEmail())
				.build();
	}

}
