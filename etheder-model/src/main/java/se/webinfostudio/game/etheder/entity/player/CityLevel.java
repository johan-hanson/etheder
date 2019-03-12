package se.webinfostudio.game.etheder.entity.player;

/**
 * Enum for CityLevel. For each level some stats change. Like max number of
 * population
 *
 * @author Johan Hanson
 */
public enum CityLevel {

	LEVEL1(1, 3000L),
	LEVEL2(2, 6000L),
	LEVEL3(3, 10000L),
	LEVEL4(4, 15000L),
	LEVEL5(5, 20000L),
	LEVEL6(6, 30000L),
	LEVEL7(7, 40000L),
	LEVEL8(8, 50000L),
	LEVEL9(9, 750000L),
	LEVEL10(10, 100000L),
	LEVEL11(11, 1250000L),
	LEVEL12(12, 1750000L),
	LEVEL13(13, 2250000L),
	LEVEL14(14, 2750000L),
	LEVEL15(15, 3750000L),
	LEVEL16(16, 4750000L),
	LEVEL17(17, 5750000L),
	LEVEL18(18, 8000000L),
	LEVEL19(19, 10000000L),
	LEVEL20(20, 12000000L);

	private static final Integer MAX_LEVEL = 20;

	public static CityLevel getNextLevel(final CityLevel cityLevel) {
		if (cityLevel.getLevel().equals(MAX_LEVEL)) {
			return LEVEL20;
		}
		return valueOf("LEVEL" + (cityLevel.getLevel() + 1));
	}

	private final Integer level;

	private final Long population;

	private CityLevel(final Integer level, final Long population) {
		this.level = level;
		this.population = population;
	}

	public Integer getLevel() {
		return level;
	}

	public Long getPopulation() {
		return population;
	}
}
