package se.webinfostudio.game.etheder.engine.dao.unit;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.unit.Unit;

/**
 *
 * @author Johan Hanson
 *
 */
public class UnitDAO extends AbstractDAO<Unit> {

	public UnitDAO(final Session session) {
		super(session, Unit.class);
	}

}
