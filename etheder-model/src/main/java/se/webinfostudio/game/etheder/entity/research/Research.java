package se.webinfostudio.game.etheder.entity.research;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import se.webinfostudio.game.etheder.entity.AbstractDataEntity;
import se.webinfostudio.game.etheder.entity.HasReference;

/**
 * Research is not unique for a player. So no need for a ResearchData.
 *
 * @author Johan Hanson
 */
@Entity
public class Research extends AbstractDataEntity implements Serializable, HasReference<ResearchRef> {

	private static final long serialVersionUID = -2576482587380432119L;

	@Column(name = "researchLevel")
	private Integer level;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(final Integer level) {
		this.level = level;
	}

	@Override
	public ResearchRef toRef() {
		return new ResearchRef(getId());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(13).append("Research: ").append(getId());
		return sb.toString();
	}
}
