package se.webinfostudio.game.etheder.entity.research;

import javax.validation.constraints.NotNull;

import se.webinfostudio.game.etheder.entity.AbstractQueueEntity;
import se.webinfostudio.game.etheder.entity.player.PlayerRef;

/**
 *
 * @author Johan Hanson
 */
//@NamedQueries({
//		@NamedQuery(name = "ResearchQueue.findAllFinished", query = "select rq from ResearchQueue rq WHERE rq.ticks=0"),
//		@NamedQuery(name = "ResearchQueue.decreaseTicks", query = "UPDATE ResearchQueue rq SET rq.ticks = rq.ticks-1 WHERE rq.ticks>0"),
//		@NamedQuery(name = "ResearchQueue.findByPlayer", query = "select rq from ResearchQueue rq WHERE rq.player.playerId=?1") })
public class ResearchQueue extends AbstractQueueEntity {

	private static final long serialVersionUID = 3120070565934790623L;

	@NotNull
	private Research research;

	@NotNull
	private PlayerRef player;

	public PlayerRef getPlayer() {
		return player;
	}

	public Research getResearch() {
		return research;
	}

	public void setPlayer(final PlayerRef player) {
		this.player = player;
	}

	public void setResearch(final Research research) {
		this.research = research;
	}
}
