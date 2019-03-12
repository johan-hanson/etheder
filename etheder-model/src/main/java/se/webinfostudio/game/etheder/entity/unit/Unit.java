package se.webinfostudio.game.etheder.entity.unit;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;
import se.webinfostudio.game.etheder.entity.HasReference;

/**
 * A unique entity for an unit.
 *
 * @author Johan Hanson
 */
@Entity
public class Unit extends AbstractGameEntity implements Serializable, HasReference<UnitRef> {

	private static final long serialVersionUID = -8789282115358229337L;

	private Integer attack;
	private Integer defensive;
	private Integer armour;
	private Integer speed;
	private Integer health;

	@NotNull
	@OneToOne(cascade = CascadeType.PERSIST)
	private UnitData unitData;

	/**
	 * @return the armour
	 */
	public Integer getArmour() {
		return armour;
	}

	/**
	 * @return the attack
	 */
	public Integer getAttack() {
		return attack;
	}

	/**
	 * @return the defensive
	 */
	public Integer getDefensive() {
		return defensive;
	}

	public Integer getHealth() {
		return health;
	}

	/**
	 * @return the speed
	 */
	public Integer getSpeed() {
		return speed;
	}

	public UnitData getUnitData() {
		return unitData;
	}

	/**
	 * @param armour the armour to set
	 */
	public void setArmour(final Integer armour) {
		this.armour = armour;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(final Integer attack) {
		this.attack = attack;
	}

	/**
	 * @param defensive the defensive to set
	 */
	public void setDefensive(final Integer defensive) {
		this.defensive = defensive;
	}

	public void setHealth(final Integer health) {
		this.health = health;
	}

	/**
	 * @param speed the speed to set
	 */
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
