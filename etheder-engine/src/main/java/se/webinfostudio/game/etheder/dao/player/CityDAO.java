package se.webinfostudio.game.etheder.dao.player;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityDAO extends AbstractDAO<City> {

	@Inject
	public CityDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public City persist(final City city) {
		return super.persist(city);
	}
}
