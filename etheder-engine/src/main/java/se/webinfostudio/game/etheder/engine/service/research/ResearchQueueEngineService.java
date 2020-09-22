package se.webinfostudio.game.etheder.engine.service.research;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;
import se.webinfostudio.game.etheder.repository.research.ResearchQueueRepository;
import se.webinfostudio.game.etheder.repository.research.ResearchRepository;

/**
 *
 * @author Johan Hanson
 */
@Named
public class ResearchQueueEngineService {

	private final static Logger LOGGER = getLogger(ResearchQueueEngineService.class);

	@Inject
	private PlayerRepository playerRepository;

	@Inject
	private ResearchQueueRepository researchQueueRepository;

	@Inject
	private ResearchRepository researchRepository;

	/**
	 * Updates all queues. If a research is finished the research will be added to
	 * the player.
	 */
	public void updateAllQueuesAndCreateResearches() {
		LOGGER.info("Start updateAllQueuesAndResearches");

		final int nrOfRowsUpdated = researchQueueRepository.decreaseTicks();
		if (nrOfRowsUpdated > 0) {
			final List<ResearchQueue> researchQueues = researchQueueRepository.findAllFinished();
			researchQueues.forEach(rq -> {
				final Player player = playerRepository.findById(rq.getPlayerId());
				final Research research = researchRepository.findById(rq.getResearchId());
				player.addTechLevel(research.getUnitType());
				playerRepository.update(player);
				researchQueueRepository.remove(rq.getId());

			});
		}
		LOGGER.info("End updateAllQueuesAndResearches");
	}
}
