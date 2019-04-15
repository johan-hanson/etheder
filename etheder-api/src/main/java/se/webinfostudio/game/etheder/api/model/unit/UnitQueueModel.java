package se.webinfostudio.game.etheder.api.model.unit;

/**
 *
 * @author Johan Hanson
 *
 */
public class UnitQueueModel {

	public static final class Builder {

		private String unitQueueId;
		private Long unitId;
		private String unitName;
		private String description;
		private String cityId;
		private Integer numberOf;

		public UnitQueueModel build() {
			final UnitQueueModel unitQueueModel = new UnitQueueModel();
			unitQueueModel.unitQueueId = unitQueueId;
			unitQueueModel.unitId = unitId;
			unitQueueModel.unitName = unitName;
			unitQueueModel.cityId = cityId;
			unitQueueModel.description = description;
			unitQueueModel.numberOf = numberOf;
			return unitQueueModel;
		}

		public Builder withCityId(final String cityId) {
			this.cityId = cityId;
			return this;
		}

		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}

		public Builder withNumberOf(final Integer numberOf) {
			this.numberOf = numberOf;
			return this;
		}

		public Builder withUnitId(final Long unitId) {
			this.unitId = unitId;
			return this;
		}

		public Builder withUnitName(final String unitName) {
			this.unitName = unitName;
			return this;
		}

		public Builder withUnitQueueId(final String unitQueueId) {
			this.unitQueueId = unitQueueId;
			return this;
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	private String unitQueueId;

	private Long unitId;

	private String unitName;

	private String cityId;

	private String description;

	private Integer numberOf;

	public String getCityId() {
		return cityId;
	}

	public String getDescription() {
		return description;
	}

	public Integer getNumberOf() {
		return numberOf;
	}

	public Long getUnitId() {
		return unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public String getUnitQueueId() {
		return unitQueueId;
	}
}
