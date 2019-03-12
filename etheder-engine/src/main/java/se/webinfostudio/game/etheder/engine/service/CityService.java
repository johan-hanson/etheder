package se.webinfostudio.game.etheder.engine.service;

import java.math.BigDecimal;

import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityLevel;
import se.webinfostudio.game.etheder.util.CalculateUtils;

/**
 *
 * @author Johan Hanson
 */
@Named
public class CityService {

	/**
	 * Calculate the new population. Algoritm: min(maxPopulation,
	 * nextLevelPopulation)/20
	 *
	 * @param city the city witch population will be calculated
	 * @return
	 */
	Long calculateNewPopulation(final City city) {
		final Long nextLevelPopulation = CityLevel.getNextLevel(city.getCityLevel()).getPopulation();

//        final Long maxPopulation = city.getBuildingList().stream().mapToLong(e -> e.getBuildingData().getPopulationCapacity()).sum();
		final Long maxPopulation = 10L;

		return city.getPopulation()
				+ ((BigDecimal.valueOf(nextLevelPopulation).min(BigDecimal.valueOf(maxPopulation)).longValue()
						- city.getPopulation()) / 20);
	}

	CityLevel checkCityLevel(final City city) {
		final CityLevel nextLevel = CityLevel.getNextLevel(city.getCityLevel());

		if (city.getCityLevel() == nextLevel) {
			return city.getCityLevel();
		}

		if (CalculateUtils.isPercentOf(new BigDecimal(city.getPopulation()), new BigDecimal(nextLevel.getPopulation()),
				90)) {
			return nextLevel;
		}
		return city.getCityLevel();
	}

}
