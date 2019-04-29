package se.webinfostudio.game.etheder.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.core.UnitType;

/**
 * Superclass for the data classses. The data classes is created from a
 * Excel-file. It will set some standard data to the class.
 *
 * @author Johan Hanson
 */
@MappedSuperclass
public abstract class AbstractDataEntity extends AbstractBasicEntity {

	private static final long serialVersionUID = 448993716831201568L;

	@Id
	private Long id;

	@NotNull
	private String name;
	private String description;
	private Long costIron;
	private Long costWood;
	private Long costStone;
	private Long costFood;
	private Long costGold;

	/**
	 * Ticks it takes to construct the building.
	 */
	private Integer ticks;

//    @Convert(converter = UnitTypeConverter.class)
	@Enumerated(EnumType.STRING)
	private UnitType unitType;

	public Long getCostFood() {
		return costFood;
	}

	public Long getCostGold() {
		return costGold;
	}

	public Long getCostIron() {
		return costIron;
	}

	public Long getCostStone() {
		return costStone;
	}

	public Long getCostWood() {
		return costWood;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getTicks() {
		return ticks;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setCostFood(final Long costFood) {
		this.costFood = costFood;
	}

	public void setCostGold(final Long costGold) {
		this.costGold = costGold;
	}

	public void setCostIron(final Long costIron) {
		this.costIron = costIron;
	}

	public void setCostStone(final Long costStone) {
		this.costStone = costStone;
	}

	public void setCostWood(final Long costWood) {
		this.costWood = costWood;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setTicks(final Integer ticks) {
		this.ticks = ticks;
	}

	public void setUnitType(final UnitType unitType) {
		this.unitType = unitType;
	}
}
