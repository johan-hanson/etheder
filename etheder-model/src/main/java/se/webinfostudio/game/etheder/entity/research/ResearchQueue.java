package se.webinfostudio.game.etheder.entity.research;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractQueueEntity;
import se.webinfostudio.game.etheder.entity.player.PlayerRef;

/**
 *
 * @author Johan Hanson
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "ResearchQueue.findAllFinished", query = "select rq from ResearchQueue rq WHERE rq.ticks=0"),
		@NamedQuery(name = "ResearchQueue.decreaseTicks", query = "UPDATE ResearchQueue rq SET rq.ticks = rq.ticks-1 WHERE rq.ticks>0"),
		@NamedQuery(name = "ResearchQueue.findByPlayer", query = "select rq from ResearchQueue rq WHERE rq.player.playerId=?1") })
public class ResearchQueue extends AbstractQueueEntity {

	private static final long serialVersionUID = 3120070565934790623L;

	@NotNull
	@Embedded
	private ResearchRef research;

	@NotNull
	@Embedded
	private PlayerRef player;

	public PlayerRef getPlayer() {
		return player;
	}

	public ResearchRef getResearch() {
		return research;
	}

	public void setPlayer(final PlayerRef player) {
		this.player = player;
	}

	public void setResearch(final ResearchRef research) {
		this.research = research;
	}
}
