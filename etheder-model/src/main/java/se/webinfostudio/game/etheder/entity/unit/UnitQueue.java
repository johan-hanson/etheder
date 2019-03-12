package se.webinfostudio.game.etheder.entity.unit;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractQueueEntity;
import se.webinfostudio.game.etheder.entity.player.CityRef;

/**
 *
 * @author Johan Hanson
 */
@Entity
@NamedQueries({ @NamedQuery(name = "UnitQueue.findAllFinished", query = "select uq from UnitQueue uq WHERE uq.ticks=0"),
		@NamedQuery(name = "UnitQueue.decreaseTicks", query = "UPDATE UnitQueue uq SET uq.ticks = uq.ticks-1 WHERE uq.ticks>0"),
		@NamedQuery(name = "UnitQueue.findByCity", query = "select uq from UnitQueue uq WHERE uq.city.cityId=?1") })
public class UnitQueue extends AbstractQueueEntity {

	private static final long serialVersionUID = -7337063928588622735L;

	@NotNull
	@OneToOne
	@AttributeOverride(name = "id", column = @Column(name = "UNIT_ID", insertable = false, updatable = false))
	private UnitData unit;

	@NotNull
	@Embedded
	private CityRef city;

	/**
	 * # of units of type Unit
	 */
	@NotNull
	private Integer nrOfUnits;

	public CityRef getCity() {
		return city;
	}

	public Integer getNrOfUnits() {
		return nrOfUnits;
	}

	public UnitData getUnit() {
		return unit;
	}

	public void setCity(final CityRef city) {
		this.city = city;
	}

	public void setNrOfUnits(final Integer nrOfUnits) {
		this.nrOfUnits = nrOfUnits;
	}

	public void setUnit(final UnitData unit) {
		this.unit = unit;
	}
}
