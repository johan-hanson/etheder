package se.webinfostudio.game.etheder.engine.service;

import static org.junit.Assert.assertEquals;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;

import org.junit.jupiter.api.Test;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityLevel;

/**
 *
 * @author Johan Hanson
 */
public class CityServiceTest {

	public CityServiceTest() {
	}

	/**
	 * Test of calculateNewPopulation method, of class CityService.
	 */
//	@Test
	public void calculateNewPopulation() {
		final City city = createCity();
		final CityService instance = new CityService();
		final Long expResult = 475L;
		final Long result = instance.calculateNewPopulation(city);
		assertEquals(expResult, result);

	}

	/**
	 * Test of checkCityLevel method, of class CityService.
	 */
	@Test
	void checkCityLevel() {
		final City city = createCity();
		final CityService instance = new CityService();
		final CityLevel expResult = CityLevel.LEVEL1;
		final CityLevel result = instance.checkCityLevel(city);
		assertEquals(expResult, result);
	}

}
