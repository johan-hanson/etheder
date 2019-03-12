package se.webinfostudio.game.etheder.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Johan Hanson
 */
public final class CalculateUtils {

	public static boolean isPercentOf(final BigDecimal value, final BigDecimal total, final int percent) {
		final BigDecimal percentOf = value.multiply(new BigDecimal(100)).divide(total, 3, RoundingMode.HALF_UP);
		return percentOf.intValue() >= percent;
	}
}
