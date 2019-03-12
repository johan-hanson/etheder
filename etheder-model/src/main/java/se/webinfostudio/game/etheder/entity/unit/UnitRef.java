package se.webinfostudio.game.etheder.entity.unit;

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
public class UnitRef implements EntityReference {

	private static final long serialVersionUID = 8882018431571466595L;

	private final UUID unitId;

	public UnitRef() {
		unitId = null;
	}

	public UnitRef(final Unit unit) {
		unitId = unit.getId();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (obj instanceof UnitRef) {
			final UnitRef rhs = (UnitRef) obj;
			return new EqualsBuilder().append(unitId, rhs.unitId).isEquals();
		}
		return false;
	}

	@Override
	public UUID getId() {
		return unitId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(7, 97).append(unitId).toHashCode();
	}
}
