package se.webinfostudio.game.etheder.entity.player;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;
import se.webinfostudio.game.etheder.entity.HasReference;
import se.webinfostudio.game.etheder.entity.unit.UnitType;

/**
 *
 * @author Johan Hanson
 */
@Entity
public class Army extends AbstractGameEntity implements HasReference<ArmyRef> {

	private static final long serialVersionUID = 596060513989334677L;

	/**
	 * The default name of the default army.
	 */
	public static final String DEFAULT_NAME = "Default army";

	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	private Player player;
	private Boolean defaultArmy;
	@Min(0)
	private Integer nrOfInfantry = 0;
	@Min(0)
	private Integer nrOfCavalry = 0;
	@Min(0)
	private Integer nrOfArcher = 0;
	@Min(0)
	private Integer nrOfSiege = 0;

	/**
	 * Adds units of an unitType to the army.
	 *
	 * @param unitType  {@link UnitType}
	 * @param nrOfUnits # of units
	 */
	public void addUnits(final UnitType unitType, final Integer nrOfUnits) {
		switch (unitType) {
		case INFANTRY:
			setNrOfInfantry(getNrOfInfantry() + nrOfUnits);
			break;
		case CAVALRY:
			setNrOfCavalry(getNrOfCavalry() + nrOfUnits);
			break;
		case ARCHER:
			setNrOfArcher(getNrOfArcher() + nrOfUnits);
			break;
		case SIEGE:
			setNrOfSiege(getNrOfSiege() + nrOfUnits);
			break;
		default:
			throw new IllegalArgumentException("UnitType not defined");
		}
	}

	public Boolean getDefaultArmy() {
		return defaultArmy;
	}

	public String getName() {
		return name;
	}

	public Integer getNrOfArcher() {
		return nrOfArcher;
	}

	public Integer getNrOfCavalry() {
		return nrOfCavalry;
	}

	public Integer getNrOfInfantry() {
		return nrOfInfantry;
	}

	public Integer getNrOfSiege() {
		return nrOfSiege;
	}

	public Player getPlayer() {
		return player;
	}

	public void setDefaultArmy(final Boolean defaultArmy) {
		this.defaultArmy = defaultArmy;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setNrOfArcher(final Integer nrOfArcher) {
		this.nrOfArcher = nrOfArcher;
	}

	public void setNrOfCavalry(final Integer nrOfCavalry) {
		this.nrOfCavalry = nrOfCavalry;
	}

	public void setNrOfInfantry(final Integer nrOfInfantry) {
		this.nrOfInfantry = nrOfInfantry;
	}

	public void setNrOfSiege(final Integer nrOfSiege) {
		this.nrOfSiege = nrOfSiege;
	}

	public void setPlayer(final Player player) {
		this.player = player;
	}

	@Override
	public ArmyRef toRef() {
		return new ArmyRef(id);
	}

}
