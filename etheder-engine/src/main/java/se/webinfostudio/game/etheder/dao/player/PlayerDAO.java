package se.webinfostudio.game.etheder.dao.player;

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

	@Override
	public Player persist(final Player player) {
		return super.persist(player);
	}
}
