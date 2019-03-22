package se.webinfostudio.game.etheder.entity.unit;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static se.webinfostudio.game.etheder.entity.unit.UnitType.CAVALRY;
import static se.webinfostudio.game.etheder.entity.unit.UnitType.INFANTRY;

import org.junit.jupiter.api.Test;

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
