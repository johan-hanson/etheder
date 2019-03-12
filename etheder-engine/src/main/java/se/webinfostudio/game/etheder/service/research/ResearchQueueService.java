package se.webinfostudio.game.etheder.service.research;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
@Named
public class ResearchQueueService {

//	@Inject
//	private ResearchQueueRepository researchQueueRepository;

//	@Inject
//	private PlayerRepository playerRepository;

	@Inject
	private WalletService walletService;

	/**
	 * Finds all researchqueues for a player.
	 *
	 * @param player {@link Player}
	 * @return {@link BuildingQueue}
	 */
	public List<ResearchQueue> findByPlayer(final Player player) {
//		return researchQueueRepository.findByPlayer(player);
		return null;
	}

	/**
	 * .
	 *
	 * @param research {@link Research}
	 * @param player   {@link Player}
	 */
	public void research(final Research research, final Player player) {
		walletService.pay(player, research);
//		playerRepository.update(player);
		final ResearchQueue researchQueue = new ResearchQueue();
		researchQueue.setResearch(research.toRef());
		researchQueue.setTicks(research.getTicks());
		researchQueue.setPlayer(player.toRef());
//		researchQueueRepository.create(researchQueue);
	}

}
