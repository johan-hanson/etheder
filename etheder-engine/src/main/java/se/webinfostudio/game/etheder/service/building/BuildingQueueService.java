package se.webinfostudio.game.etheder.service.building;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.building.BuildingDataDAO;
import se.webinfostudio.game.etheder.dao.building.BuildingQueueDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
@Named
public class BuildingQueueService {

	@Inject
	private BuildingDataDAO buildingDataDAO;

	@Inject
	private BuildingQueueDAO buildingQueueDAO;
//
//	@Inject
//	private PlayerRepository playerRepository;

	@Inject
	private WalletService walletService;

	/**
	 * Create a {@link BuildingQueue}
	 *
	 * @param buildingQueue {@link BuildingQueue}
	 * @return the saved {@link BuildingQueue}
	 */
	public BuildingQueue createBuildingQueue(final BuildingQueue buildingQueue) {
		// validation...
		buildingQueue.setBuilding(buildingDataDAO.findById(buildingQueue.getBuilding().getId()));
		buildingQueue.setTicks(buildingQueue.getBuilding().getTicks());
		return buildingQueueDAO.persist(buildingQueue);
	}

	/**
	 * .
	 *
	 * @param city the city
	 * @return list of {@link BuildingQueue}
	 */
	public List<BuildingQueue> findByCity(final City city) {
//		return buildingQueueRepository.findByCity(city);
		return null;
	}

}
