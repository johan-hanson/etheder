package se.webinfostudio.game.etheder.entity.building;

import se.webinfostudio.game.etheder.entity.AbstractDataEntity;

/**
 * Class for data of a building
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
public class BuildingData extends AbstractDataEntity {

	private static final long serialVersionUID = 7439857429174113731L;

	/**
	 * Max number of buildings you can build.
	 */
	private Integer maxNumber;

	/**
	 * How many populationCapacity the building can house.
	 */
	private Integer populationCapacity;

	public BuildingData() {
	}

	public Integer getMaxNumber() {
		return maxNumber;
	}

	public Integer getPopulationCapacity() {
		return populationCapacity;
	}

	public void setMaxNumber(final Integer maxNumber) {
		this.maxNumber = maxNumber;
	}

	public void setPopulationCapacity(final Integer populationCapacity) {
		this.populationCapacity = populationCapacity;
	}

}
