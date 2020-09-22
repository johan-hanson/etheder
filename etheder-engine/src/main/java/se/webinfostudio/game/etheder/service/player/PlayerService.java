package se.webinfostudio.game.etheder.service.player;

import java.io.Serializable;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;

/**
 *
 * @author Johan Hanson
 */
@Named
public class PlayerService implements Serializable {

	private static final long serialVersionUID = 5583961908675264504L;

	@Inject
	private PlayerRepository playerRepository;

	/**
	 * Saves a new player to the database.
	 *
	 * @param player {@link Player}
	 */
	public Player createPlayer(final Player player) {
		// validation... todo
		playerRepository.create(player);
		return player;
	}

	/**
	 * Finds a player from its id.
	 *
	 * @param playerId the id fo the player to be find
	 * @return {@link Player}
	 */
	public Player getPlayer(final UUID playerId, final UUID userId) {
		final Player player = playerRepository.findById(playerId);
		if (!player.getUserId().equals(userId)) {
			throw new IllegalArgumentException("User is not allowed to get player");
		}
		return player;
	}

	public Player updatePlayer(final Player apply) {
		// TODO Auto-generated method stub
		return null;
	}

}
