package se.webinfostudio.game.etheder.api.transformer.user;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.user.UserTokenModel;
import se.webinfostudio.game.etheder.entity.user.Login;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserTokenModelTransformer implements Function<Login, UserTokenModel> {

	@Override
	public UserTokenModel apply(final Login login) {
		return UserTokenModel.newBuilder()
				.withUserName(login.getUserName())
				.withToken(login.getToken().toString())
				.build();
	}

}
