package se.webinfostudio.game.etheder.entity.research;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractQueueEntity;

/**
 *
 * @author Johan Hanson
 */
public class ResearchQueue extends AbstractQueueEntity {

	private static final long serialVersionUID = 3120070565934790623L;

	@NotNull
	private Long researchId;

	@NotNull
	private UUID playerId;

	// TODO: What is indexid in the database?

	public UUID getPlayerId() {
		return playerId;
	}

	public Long getResearchId() {
		return researchId;
	}

	public void setPlayerId(final UUID playerId) {
		this.playerId = playerId;
	}

	public void setResearchId(final Long researchId) {
		this.researchId = researchId;
	}
}
