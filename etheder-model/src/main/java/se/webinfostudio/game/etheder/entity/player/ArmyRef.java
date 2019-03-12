package se.webinfostudio.game.etheder.entity.player;

import java.io.Serializable;
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
public class ArmyRef implements EntityReference, Serializable {

	private static final long serialVersionUID = -8607332437146891257L;

	private final UUID armyId;

	public ArmyRef() {
		armyId = null;
	}

	public ArmyRef(final Army army) {
		armyId = army.getId();
	}

	public ArmyRef(final UUID armyId) {
		this.armyId = armyId;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (obj instanceof ArmyRef) {
			final ArmyRef rhs = (ArmyRef) obj;
			return new EqualsBuilder().append(armyId, rhs.armyId).isEquals();
		}
		return false;
	}

	@Override
	public UUID getId() {
		return armyId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(7, 97).append(armyId).toHashCode();
	}

}
