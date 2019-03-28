package se.webinfostudio.game.etheder.api.transformer.player;

import static java.util.UUID.fromString;
import static se.webinfostudio.game.etheder.api.transformer.TransformerHelper.createUUIDFromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.player.CityModel;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.PlayerRef;

/**
 *
 * @author Johan Hanson
 *
 */
public class CityTransformer implements Function<CityModel, City> {

	@Override
	public City apply(final CityModel cityModel) {
		final City city = new City();
		city.setId(createUUIDFromString(cityModel.getCityId()));
		city.setName(cityModel.getName());
		city.setPlayer(new PlayerRef(fromString(cityModel.getPlayerId())));
		return city;
	}

}
