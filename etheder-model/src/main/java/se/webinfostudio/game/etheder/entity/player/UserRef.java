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
public class UserRef implements EntityReference, Serializable {

	private static final long serialVersionUID = 2108887887337659264L;

	private final UUID userId;

	public UserRef() {
		userId = null;
	}

	public UserRef(final User user) {
		userId = user.getId();
	}

	public UserRef(final UUID id) {
		userId = id;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (obj instanceof UserRef) {
			final UserRef rhs = (UserRef) obj;
			return new EqualsBuilder().append(userId, rhs.userId).isEquals();
		}
		return false;
	}

	@Override
	public UUID getId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(7, 97).append(userId).toHashCode();
	}

}
