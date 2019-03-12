package se.webinfostudio.game.etheder.entity.building;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Johan Hanson
 */
public class BuildingQueueTest {

	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Test of id, of class BuildingQueue.
	 */
	@Test
	public void testId() {
		final BuildingQueue instance = new BuildingQueue();
		assertThat(instance.getId()).isNotNull();
	}

	/**
	 * Test of setTicks method, of class BuildingQueue.
	 */
	@Test
	public void testSetTicks() {
		final Integer ticks = 10;
		final BuildingQueue instance = new BuildingQueue();
		instance.setTicks(ticks);
		assertThat(instance.getTicks()).isEqualTo(ticks);
	}

}
