package se.webinfostudio.game.etheder.entity.building;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import se.webinfostudio.game.etheder.entity.AbstractGameEntity;
import se.webinfostudio.game.etheder.entity.HasReference;

/**
 * Class for an unique building per user/city.
 *
 * @author Johan Hanson
 */
@Entity(name = "building")
public class Building extends AbstractGameEntity implements Serializable, HasReference<BuildingRef> {

	private static final long serialVersionUID = -1375711736439804175L;

	@OneToOne(cascade = CascadeType.PERSIST)
	private BuildingData buildingData;

	public BuildingData getBuildingData() {
		return buildingData;
	}

	public void setBuildingData(final BuildingData buildingData) {
		this.buildingData = buildingData;
	}

	@Override
	public BuildingRef toRef() {
		return new BuildingRef(this);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(13).append("Building: ").append(id);
		return sb.toString();
	}

}
