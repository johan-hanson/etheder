package se.webinfostudio.game.etheder.entity.building;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractQueueEntity;
import se.webinfostudio.game.etheder.entity.player.CityRef;

/**
 * BuildingQueue, when building a building
 *
 * @author Johan Hanson
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "BuildingQueue.findAllFinished", query = "select bq from BuildingQueue bq WHERE bq.ticks=0"),
		@NamedQuery(name = "BuildingQueue.decreaseTicks", query = "UPDATE BuildingQueue bq SET bq.ticks = bq.ticks-1 WHERE bq.ticks>0"),
		@NamedQuery(name = "BuildingQueue.findByCity", query = "select bq from BuildingQueue bq WHERE bq.city.cityId=?1") })
public class BuildingQueue extends AbstractQueueEntity {

	private static final long serialVersionUID = 8156980671262090383L;

	@NotNull
	@OneToOne
	private BuildingData building;

	@NotNull
	@Embedded
	private CityRef city;

	public BuildingData getBuilding() {
		return building;
	}

	public CityRef getCity() {
		return city;
	}

	public void setBuilding(final BuildingData building) {
		this.building = building;
	}

	public void setCity(final CityRef city) {
		this.city = city;
	}

}
