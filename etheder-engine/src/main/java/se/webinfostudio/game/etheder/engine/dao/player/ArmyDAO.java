package se.webinfostudio.game.etheder.engine.dao.player;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.player.Army;

/**
 *
 * @author Johan Hanson
 *
 */
public class ArmyDAO extends AbstractDAO<Army> {

	public ArmyDAO(final Session session) {
		super(session, Army.class);
	}

}
