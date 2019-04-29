package se.webinfostudio.game.etheder.entity.unit;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static se.webinfostudio.game.etheder.entity.core.UnitType.CAVALRY;
import static se.webinfostudio.game.etheder.entity.core.UnitType.INFANTRY;

import org.junit.jupiter.api.Test;

import se.webinfostudio.game.etheder.entity.core.UnitType;

/**
 *
 * @author Johan Hanson
 */
public class UnitTypeTest {

	@Test
	void testUnitType() {
		final UnitType inf = INFANTRY;
		assertThat(inf, not(CAVALRY));
	}
}
