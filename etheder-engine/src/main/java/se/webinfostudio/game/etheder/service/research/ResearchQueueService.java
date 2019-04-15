package se.webinfostudio.game.etheder.service.research;

import static java.lang.String.format;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.dao.research.ResearchDAO;
import se.webinfostudio.game.etheder.dao.research.ResearchQueueDAO;
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

	@Inject
	private ResearchDAO researchDAO;

	@Inject
	private ResearchQueueDAO researchQueueDAO;

	@Inject
	private PlayerDAO playerDAO;

	@Inject
	private WalletService walletService;

	/**
	 * Creates a researchQueue for a player
	 *
	 * @param researchQueue a {@link ResearchQueue} to store
	 * @param userId        the userId on the player
	 * @return A {@link ResearchQueue}
	 */
	public ResearchQueue createResearchQueue(final ResearchQueue researchQueue, final UUID userId) {
		final UUID playerId = researchQueue.getPlayer().getId();
		final Player player = findPlayer(userId);

		validatePlayerIsPlayer(playerId, player);

		final Research research = findResearch(researchQueue.getResearch().getId());

		// Check if building can be built techlevel stuff, to decided

		walletService.pay(player, research);

		researchQueue.setTicks(research.getTicks());
		researchQueue.setResearch(research);
		researchQueueDAO.persist(researchQueue);
		playerDAO.persist(player);
		return researchQueue;
	}

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

	private Player findPlayer(final UUID userId) {
		final Optional<Player> player = playerDAO.findByUserId(userId);

		if (!player.isPresent()) {
			throw new RuntimeException("Player not found for user: " + userId);
		}
		return player.get();
	}

	private Research findResearch(final Long researchId) {
		final Optional<Research> resarch = researchDAO.findById(researchId);

		if (!resarch.isPresent()) {
			throw new RuntimeException("Research not found: " + researchId);
		}
		return resarch.get();
	}

	private void validatePlayerIsPlayer(final UUID playerId, final Player player) {
		if (!playerId.equals(player.getId())) {
			throw new RuntimeException(
					format("Player %s is not logged on player %s", playerId, player.getId().toString()));
		}
	}

}
