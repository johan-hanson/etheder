package se.webinfostudio.game.etheder.service.player;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 */
@Named
public class PlayerService implements Serializable {

	private static final long serialVersionUID = 5583961908675264504L;

	@Inject
	private PlayerDAO playerDAO;

	/**
	 * Saves a new player to the database.
	 *
	 * @param player {@link Player}
	 */
	public Player createPlayer(final Player player) {
		// validation...
		return playerDAO.persist(player);
	}

	/**
	 * Finds a player from its id.
	 *
	 * @param playerId the id fo the player to be find
	 * @return {@link Player}
	 */
	public Player findById(final Long playerId) {
//		return playerRepository.findById(playerId);
		return null;
	}

	public Player updatePlayer(final Player apply) {
		// TODO Auto-generated method stub
		return null;
	}

}
