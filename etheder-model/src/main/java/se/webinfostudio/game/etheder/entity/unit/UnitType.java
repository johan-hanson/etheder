package se.webinfostudio.game.etheder.entity.unit;

/**
 * UnitType defines what type type of unit a building, research and unit belongs
 * to.
 *
 *
 * @author Johan Hanson
 */
public enum UnitType {

	NOT_SPCIFIED("NS", "Not specified"),
	INFANTRY("I", "Infantry"),
	CAVALRY("C", "Cavalry"),
	ARCHER("A", "Archer"),
	SIEGE("S", "Siege");

	private final String label;
	private final String description;

	private UnitType(final String label, final String description) {
		this.label = label;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("UnitType");
		sb.append("{label='").append(label).append('\'');
		sb.append(", description='").append(description).append("'}");
		return sb.toString();
	}
}
