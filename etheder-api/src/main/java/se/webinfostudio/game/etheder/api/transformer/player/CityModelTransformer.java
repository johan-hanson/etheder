package se.webinfostudio.game.etheder.api.transformer.player;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.player.CityModel;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityModelTransformer implements Function<City, CityModel> {

	@Override
	public CityModel apply(final City city) {

		return CityModel.newBuilder()
				.withCityId(city.getId().toString())
				.withName(city.getName())
				.withPlayerId(city.getPlayer().getId().toString())
				.build();
	}

}
