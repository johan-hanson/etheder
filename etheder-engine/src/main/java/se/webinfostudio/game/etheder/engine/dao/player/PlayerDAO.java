package se.webinfostudio.game.etheder.engine.dao.player;

import java.util.Optional;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerDAO extends AbstractDAO<Player> {

	public PlayerDAO(final Session session) {
		super(session, Player.class);
	}

	public Optional<Player> findByCity(final CityRef city) {
		return findByNamedQuery("Player.findByCity", city).stream().findFirst();
	}
}
