package se.webinfostudio.game.etheder.service.research;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;
import se.webinfostudio.game.etheder.repository.research.ResearchQueueRepository;
import se.webinfostudio.game.etheder.repository.research.ResearchRepository;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
@Named
public class ResearchQueueService {

	@Inject
	private ResearchRepository researchRepository;

	@Inject
	private ResearchQueueRepository researchQueueRepository;

	@Inject
	private PlayerRepository playerRepository;

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
		final UUID playerId = researchQueue.getPlayerId();
		final Player player = findPlayer(userId);

		validatePlayerIsPlayer(playerId, player);

		final Research research = findResearch(researchQueue.getResearchId());

		// Check if research can be researched techlevel stuff, to decided

		walletService.pay(player, research);

		researchQueue.setTicks(research.getTicks());
		researchQueueRepository.create(researchQueue);
		playerRepository.update(player);
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
		final Optional<Player> player = playerRepository.findByUserId(userId);

		if (!player.isPresent()) {
			throw new RuntimeException("Player not found for user: " + userId);
		}
		return player.get();
	}

	private Research findResearch(final Long researchId) {
		final Optional<Research> resarch = ofNullable(researchRepository.findById(researchId));

		if (!resarch.isPresent()) {
			throw new RuntimeException("Research not found: " + researchId);
		}
		return resarch.get();
	}

	private void validatePlayerIsPlayer(final UUID playerId, final Player player) {
		if (!playerId.equals(player.getId())) {
			throw new RuntimeException(
					format("Player %s is not logged on as player %s", playerId, player.getId().toString()));
		}
	}

}
