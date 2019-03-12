package se.webinfostudio.game.etheder.entity.util;

import java.util.function.Predicate;

import se.webinfostudio.game.etheder.entity.player.CityRef;

/**
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
public final class Predicates {

	public static Predicate<CityRef> findByCityRef(final CityRef cityRef) {
		return (final CityRef city) -> {
			return city.equals(cityRef);
		};
	}

	private Predicates() {
	}
}
