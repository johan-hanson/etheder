package se.webinfostudio.game.etheder.dao.player;

import java.util.Optional;
import java.util.UUID;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerDAO extends AbstractDAO<Player> {

	@Inject
	public PlayerDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	/**
	 * Find a {@link Player} by userId.
	 *
	 * @param userId the userId on the {@link Player} to find
	 * @return An {@link Optional} of a {@link Player}
	 */
	public Optional<Player> findByUserId(final UUID userId) {
		return super.query("SELECT p FROM Player p WHERE p.user.userId=:u")
				.setParameter("u", userId)
				.getResultList()
				.stream()
				.findFirst();
	}

	@Override
	public Player persist(final Player player) {
		return super.persist(player);
	}
}
