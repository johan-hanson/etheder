package se.webinfostudio.game.etheder.dao.player;

import java.util.Optional;
import java.util.UUID;

import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerDAO {

	/**
	 * Find a {@link Player} by userId.
	 *
	 * @param userId the userId on the {@link Player} to find
	 * @return An {@link Optional} of a {@link Player}
	 */
	public Optional<Player> findByUserId(final UUID userId) {
//		return super.query("SELECT p FROM Player p WHERE p.user.userId=:u")
//				.setParameter("u", userId)
//				.getResultList()
//				.stream()
//				.findFirst();
		return Optional.empty();
	}

	public Player persist(final Player player) {
//		return super.persist(player);
		return null;
	}
}
