package se.webinfostudio.game.etheder.service.building;

import java.util.Optional;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.repository.building.BuildingDataRepository;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataService {

	@Inject
	private BuildingDataRepository buildingDataRepository;

	public Optional<BuildingData> findById(final Long id) {
		return Optional.ofNullable(buildingDataRepository.findById(id));
	}
}
