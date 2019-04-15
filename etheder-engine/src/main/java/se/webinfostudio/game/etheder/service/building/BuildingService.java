package se.webinfostudio.game.etheder.service.building;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.building.BuildingDAO;
import se.webinfostudio.game.etheder.entity.building.Building;

/**
 *
 * @author Johan Hanson
 */
@Named
public class BuildingService {

	@Inject
	private BuildingDAO buildingDAO;

	/**
	 * .
	 *
	 * @return .
	 */
	public List<Building> findAll() {
		return buildingDAO.findAll();
	}

	/**
	 * Finds a building by it id.
	 *
	 * @param buildingId the buidling id
	 * @return {@link Building}
	 */
	public Optional<Building> findById(final String buildingId) {
		return Optional.ofNullable(buildingDAO.findById(UUID.fromString(buildingId)));
	}
}
