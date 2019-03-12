package se.webinfostudio.game.etheder.api.transformer.player;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.player.PlayerModel;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerModelTransformer implements Function<Player, PlayerModel> {

	@Override
	public PlayerModel apply(final Player player) {
		return PlayerModel.newBuilder()
				.withPlayerId(player.getId().toString())
				.withUserId(player.getMyUser().getId().toString())
				.withCountry(player.getCountry()).build();
	}
}
