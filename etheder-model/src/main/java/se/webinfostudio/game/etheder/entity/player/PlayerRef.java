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
public class PlayerRef implements EntityReference, Serializable {

	private static final long serialVersionUID = -6297230487177402052L;

	private final UUID playerId;

	public PlayerRef() {
		playerId = null;
	}

	public PlayerRef(final Player player) {
		playerId = player.getId();
	}

	public PlayerRef(final UUID id) {
		playerId = id;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (obj instanceof PlayerRef) {
			final PlayerRef rhs = (PlayerRef) obj;
			return new EqualsBuilder().append(playerId, rhs.playerId).isEquals();
		}
		return false;
	}

	@Override
	public UUID getId() {
		return playerId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(11, 97).append(playerId).toHashCode();
	}

}
