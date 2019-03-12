/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.webinfostudio.game.etheder.entity.research;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import se.webinfostudio.game.etheder.entity.EntityDataReference;

/**
 *
 * @author Johan Hanson
 */
@Embeddable
public class ResearchRef implements EntityDataReference, Serializable {

	private static final long serialVersionUID = -5900707831354769403L;

	private final Long researchId;

	public ResearchRef() {
		researchId = null;
	}

	public ResearchRef(final Long researchId) {
		this.researchId = researchId;
	}

	public ResearchRef(final Research research) {
		researchId = research.getId();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (obj instanceof ResearchRef) {
			final ResearchRef rhs = (ResearchRef) obj;
			return new EqualsBuilder().append(researchId, rhs.researchId).isEquals();
		}
		return false;
	}

	@Override
	public Long getId() {
		return researchId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(9, 97).append(researchId).toHashCode();
	}
}
