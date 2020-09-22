package se.webinfostudio.game.etheder.api.transformer.player;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.player.PlayerModel;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerTransformer implements Function<PlayerModel, Player> {

	@Override
	public Player apply(final PlayerModel playerModel) {
		final Player player = new Player();
//		player.setId(createUUIDFromString(playerModel.getPlayerId()));
		player.setCountry(playerModel.getCountry());
		player.setName(playerModel.getName());
		player.setUserId(fromString(playerModel.getUserId()));
		return player;
	}
}
