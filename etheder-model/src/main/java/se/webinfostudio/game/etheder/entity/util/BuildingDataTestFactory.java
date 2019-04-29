package se.webinfostudio.game.etheder.entity.util;

import static se.webinfostudio.game.etheder.entity.core.UnitType.INFANTRY;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.core.UnitType;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataTestFactory {

	public static final class Builder {
		private Long id = 1L;
		private String name = "Barrack";
		private String description = "Barrack to create infantry";
		private UnitType unitType = INFANTRY;
		private Long costFood = 1000L;
		private Long costWood = 0L;
		private Long costGold = 0L;
		private Long costIron = 0L;
		private Long costStone = 0L;
		private Integer ticks = 10;

		public BuildingData build() {
			final BuildingData buildingData = new BuildingData();
			buildingData.setId(id);
			buildingData.setName(name);
			buildingData.setDescription(description);
			buildingData.setUnitType(unitType);
			buildingData.setCostFood(costFood);
			buildingData.setCostGold(costGold);
			buildingData.setCostIron(costIron);
			buildingData.setCostStone(costStone);
			buildingData.setCostWood(costWood);
			buildingData.setTicks(ticks);
			return buildingData;
		}

		public Builder withCostFood(final Long food) {
			costFood = food;
			return this;
		}

		public Builder withCostGold(final Long gold) {
			costGold = gold;
			return this;
		}

		public Builder withCostIron(final Long iron) {
			costIron = iron;
			return this;
		}

		public Builder withCostStone(final Long stone) {
			costStone = stone;
			return this;
		}

		public Builder withCostWood(final Long wood) {
			costWood = wood;
			return this;
		}

		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}

		public Builder withId(final Long id) {
			this.id = id;
			return this;
		}

		public Builder withName(final String name) {
			this.name = name;
			return this;
		}

		public Builder withTicks(final Integer ticks) {
			this.ticks = ticks;
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

	private BuildingDataTestFactory() {
		// not used
	}

}
