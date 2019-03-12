package se.webinfostudio.game.etheder.engine.dao.research;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchDAO extends AbstractDAO<Research> {

	public ResearchDAO(final Session session) {
		super(session, Research.class);
	}

}
