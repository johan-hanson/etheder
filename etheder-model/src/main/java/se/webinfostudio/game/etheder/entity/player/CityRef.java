package se.webinfostudio.game.etheder.entity.player;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import se.webinfostudio.game.etheder.entity.EntityReference;

/**
 * A reference class for a city
 *
 * @author Johan Hanson
 */
@Embeddable
public class CityRef implements EntityReference, Serializable {

	private static final long serialVersionUID = -913536209118789936L;

	private final UUID cityId;

	public CityRef() {
		cityId = null;
	}

	public CityRef(final City city) {
		cityId = city.getId();
	}

	public CityRef(final UUID id) {
		cityId = id;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (obj instanceof CityRef) {
			final CityRef rhs = (CityRef) obj;
			return new EqualsBuilder().append(cityId, rhs.cityId).isEquals();
		}
		return false;
	}

	@Override
	public UUID getId() {
		return cityId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(7, 97).append(cityId).toHashCode();
	}
}
