package se.webinfostudio.game.etheder.entity.unit;

import se.webinfostudio.game.etheder.entity.AbstractDataEntity;

/**
 * Class for an unit and its stats.
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
public class UnitData extends AbstractDataEntity {

	private static final long serialVersionUID = 6357384312861762046L;

	private Integer attack;
	private Integer defensive;
	private Integer armour;
	private Integer speed;
	private Integer health;

	private Integer level;
	private Integer timeToProduce;
	private Integer travelTime;
	private boolean canFly;
	private boolean canShotFlyingUnits;

	public UnitData() {
	}

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

	public Integer getLevel() {
		return level;
	}

	public Integer getSpeed() {
		return speed;
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

	public void setLevel(final Integer level) {
		this.level = level;
	}

	public void setSpeed(final Integer speed) {
		this.speed = speed;
	}
}
