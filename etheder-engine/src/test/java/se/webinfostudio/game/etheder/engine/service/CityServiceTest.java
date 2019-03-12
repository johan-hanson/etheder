package se.webinfostudio.game.etheder.engine.service;

import static org.junit.Assert.assertEquals;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityLevel;

/**
 *
 * @author Johan Hanson
 */
public class CityServiceTest {

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

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
	public void checkCityLevel() {
		final City city = createCity();
		final CityService instance = new CityService();
		final CityLevel expResult = CityLevel.LEVEL1;
		final CityLevel result = instance.checkCityLevel(city);
		assertEquals(expResult, result);
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

}
