package se.webinfostudio.game.etheder.service.player;

import static org.apache.commons.lang3.Validate.notNull;

import java.util.Set;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.util.Predicates;
import se.webinfostudio.game.etheder.repository.player.CityRepository;

/**
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
public class CityService {

	@Inject
	private CityRepository cityRepository;

	public boolean cityExistInList(final Set<CityRef> cityList, final CityRef cityRef) {
		notNull(cityList);
		notNull(cityRef);

		return cityList.stream().anyMatch(Predicates.findByCityRef(cityRef));
	}

	public City createCity(final City city) {
		// validation...
		cityRepository.create(city);
		return city;
	}

}
