package se.webinfostudio.game.etheder.entity.unit;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.webinfostudio.game.etheder.entity.player.CityRef;

/**
 *
 * @author Johan Hanson
 */
public class UnitQueueTest {

	@BeforeClass
	public static void setUpClass() {
	}

	public UnitQueueTest() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of setId method, of class UnitQueue.
	 */
	@Test
	public void testSetId() {
		final UUID id = randomUUID();
		final UnitQueue instance = new UnitQueue();
		instance.setId(id);
		assertThat(instance.getId()).isEqualTo(id);
	}

	/**
	 * Test of setPlayer method, of class UnitQueue.
	 */
	@Test
	public void testSetPlayer() {
		final CityRef city = new CityRef();
		final UnitQueue instance = new UnitQueue();
		instance.setCity(city);
		assertThat(instance.getCity()).isEqualTo(city);
	}

	/**
	 * Test of setTicks method, of class UnitQueue.
	 */
	@Test
	public void testSetTicks() {
		final Integer ticks = 10;
		final UnitQueue instance = new UnitQueue();
		instance.setTicks(ticks);
		assertThat(instance.getTicks()).isEqualTo(ticks);
	}

}
