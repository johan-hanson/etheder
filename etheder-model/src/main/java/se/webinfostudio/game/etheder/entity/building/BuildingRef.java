package se.webinfostudio.game.etheder.entity.building;

import java.util.UUID;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import se.webinfostudio.game.etheder.entity.EntityReference;

/**
 *
 * @author Johan Hanson
 */
@Embeddable
public class BuildingRef implements EntityReference {

	private static final long serialVersionUID = -12292231919018382L;

	private final UUID buildingId;

	public BuildingRef(final Building building) {
		buildingId = building.getId();
	}

	protected BuildingRef() {
		buildingId = null;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (obj instanceof BuildingRef) {
			final BuildingRef rhs = (BuildingRef) obj;
			return new EqualsBuilder().append(buildingId, rhs.buildingId).isEquals();
		}
		return false;
	}

	@Override
	public UUID getId() {
		return buildingId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 97).append(buildingId).toHashCode();
	}
}
