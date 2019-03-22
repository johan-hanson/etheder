package se.webinfostudio.game.etheder.entity.unit;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import se.webinfostudio.game.etheder.entity.player.CityRef;

/**
 *
 * @author Johan Hanson
 */
public class UnitQueueTest {

	@Test
	void testSetId() {
		final UUID id = randomUUID();
		final UnitQueue instance = new UnitQueue();
		instance.setId(id);
		assertThat(instance.getId()).isEqualTo(id);
	}

	@Test
	void testSetPlayer() {
		final CityRef city = new CityRef();
		final UnitQueue instance = new UnitQueue();
		instance.setCity(city);
		assertThat(instance.getCity()).isEqualTo(city);
	}

	@Test
	void testSetTicks() {
		final Integer ticks = 10;
		final UnitQueue instance = new UnitQueue();
		instance.setTicks(ticks);
		assertThat(instance.getTicks()).isEqualTo(ticks);
	}

}
