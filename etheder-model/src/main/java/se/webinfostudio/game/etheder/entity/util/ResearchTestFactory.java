package se.webinfostudio.game.etheder.entity.util;

import static se.webinfostudio.game.etheder.entity.core.UnitType.INFANTRY;

import se.webinfostudio.game.etheder.entity.core.UnitType;
import se.webinfostudio.game.etheder.entity.research.Research;

public class ResearchTestFactory {

	public static final class Builder {
		private Long id = 1L;
		private String name = "Barracks upgrade";
		private String description = "Upgrades barrack an let you create better infantry";
		private UnitType unitType = INFANTRY;
		private Integer level = 2;

		public Research build() {
			final Research research = new Research();
			research.setId(id);
			research.setName(name);
			research.setDescription(description);
			research.setUnitType(unitType);
			research.setLevel(level);
			return research;
		}

		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}

		public Builder withId(final Long id) {
			this.id = id;
			return this;
		}

		public Builder withLeveel(final Integer level) {
			this.level = level;
			return this;
		}

		public Builder withName(final String name) {
			this.name = name;
			return this;
		}

		public Builder withUnitType(final UnitType unitType) {
			this.unitType = unitType;
			return this;
		}

	}

	public static Builder newBuilder() {
		return new Builder();
	}

	private ResearchTestFactory() {
		// not used
	}

}
