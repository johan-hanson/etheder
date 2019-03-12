package se.webinfostudio.game.etheder.service.player;

import static org.apache.commons.lang3.Validate.notNull;

import java.util.Set;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.dao.player.CityDAO;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.util.Predicates;

/**
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
public class CityService {

	private final CityDAO cityDAO;

	@Inject
	public CityService(final CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	public boolean cityExistInList(final Set<CityRef> cityList, final CityRef cityRef) {
		notNull(cityList);
		notNull(cityRef);

		return cityList.stream().anyMatch(Predicates.findByCityRef(cityRef));
	}

	public City createCity(final City city) {
		// validation...
		return cityDAO.persist(city);
	}

}
