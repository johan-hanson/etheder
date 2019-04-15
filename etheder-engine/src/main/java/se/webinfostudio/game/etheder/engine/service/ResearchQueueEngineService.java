package se.webinfostudio.game.etheder.engine.service;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.slf4j.Logger;

import se.webinfostudio.game.etheder.engine.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.engine.dao.research.ResearchQueueDAO;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

/**
 *
 * @author Johan Hanson
 */
@Named
public class ResearchQueueEngineService {

	private final static Logger LOGGER = getLogger(ResearchQueueEngineService.class);

	@Inject
	private final PlayerDAO playerDAO;

	@Inject
	private final ResearchQueueDAO researchQueueDAO;

	public ResearchQueueEngineService(final Session session) {
		researchQueueDAO = new ResearchQueueDAO(session);
		playerDAO = new PlayerDAO(session);
	}

	/**
	 * Updates all queues. If a research is finished the research will be added to
	 * the player.
	 */
	public void updateAllQueuesAndCreateResearches() {
		LOGGER.info("Start updateAllQueuesAndResearches");

		final int nrOfRowsUpdated = researchQueueDAO.decreaseTicks();
		if (nrOfRowsUpdated > 0) {
			final List<ResearchQueue> researchQueues = researchQueueDAO.findAllFinished();
			researchQueues.forEach(rq -> {
				final Player player = playerDAO.findByRef(rq.getPlayer());
				final Research research = rq.getResearch();
				player.addTechLevel(research.getUnitType());
				playerDAO.persist(player);
				researchQueueDAO.remove(rq);

			});
		}
		LOGGER.info("End updateAllQueuesAndResearches");
	}
}
