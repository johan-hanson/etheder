package se.webinfostudio.game.etheder.api.transformer.player;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.player.CityModel;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityTransformer implements Function<CityModel, City> {

	@Override
	public City apply(final CityModel cityModel) {
		final City city = new City();
		if (cityModel.getCityId() != null) {
			city.setId(fromString(cityModel.getCityId()));
		}
		city.setName(cityModel.getName());
		city.setPlayerId(fromString(cityModel.getPlayerId()));
		return city;
	}

}
