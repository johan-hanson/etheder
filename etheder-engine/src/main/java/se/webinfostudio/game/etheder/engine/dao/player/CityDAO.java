package se.webinfostudio.game.etheder.engine.dao.player;

import org.hibernate.Session;

import se.webinfostudio.game.etheder.engine.dao.AbstractDAO;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityDAO extends AbstractDAO<City> {

	public CityDAO(final Session session) {
		super(session, City.class);
	}
}
