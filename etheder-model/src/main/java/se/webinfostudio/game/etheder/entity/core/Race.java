package se.webinfostudio.game.etheder.entity.core;

/**
 *
 * @author Johan Hanson
 *
 */
public enum Race {

	HUMANS("Humans"),
	WOOD_ELVES("Wood Elves"),
	DWARVES("Dwarves"),
	ORCS("Orcs"),
	UNDEAD("Undead");

	private String name;

	Race(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
