package se.webinfostudio.game.etheder.entity.unit;

import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;
import se.webinfostudio.game.etheder.entity.HasReference;

/**
 * A unique entity for an unit. Not anymore...
 *
 * @author Johan Hanson
 */
public class Unit extends AbstractGameEntity implements HasReference<UnitRef> {

	private static final long serialVersionUID = -8789282115358229337L;

	private Integer attack;
	private Integer defensive;
	private Integer armour;
	private Integer speed;
	private Integer strength;
	private Integer toughness;
	private Integer initiative;
	private Integer weaponskill;
	private Integer health;
	private Integer hitPoints;
	private Integer minPower;
	private Integer maxPower;

	@NotNull
	private UnitData unitData;

	public Integer getArmour() {
		return armour;
	}

	public Integer getAttack() {
		return attack;
	}

	public Integer getDefensive() {
		return defensive;
	}

	public Integer getHealth() {
		return health;
	}

	public Integer getSpeed() {
		return speed;
	}

	public UnitData getUnitData() {
		return unitData;
	}

	public void setArmour(final Integer armour) {
		this.armour = armour;
	}

	public void setAttack(final Integer attack) {
		this.attack = attack;
	}

	public void setDefensive(final Integer defensive) {
		this.defensive = defensive;
	}

	public void setHealth(final Integer health) {
		this.health = health;
	}

	public void setSpeed(final Integer speed) {
		this.speed = speed;
	}

	public void setUnitData(final UnitData unitData) {
		this.unitData = unitData;
	}

	/**
	 * Returns a ref of Unit.
	 *
	 * @return {@link UnitRef}
	 */
	@Override
	public UnitRef toRef() {
		return new UnitRef(this);
	}

	@Override
	public String toString() {
		return String.format("Unit: %s", id);
	}

}
