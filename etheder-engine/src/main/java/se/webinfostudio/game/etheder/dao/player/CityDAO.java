package se.webinfostudio.game.etheder.dao.player;

import java.util.Optional;
import java.util.UUID;

import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityDAO {

	public Optional<City> findById(final UUID id) {
		// return ofNullable(super.get(id));
		return Optional.empty();
	}

	public City persist(final City city) {
		// return super.persist(city);
		return null;
	}
}
