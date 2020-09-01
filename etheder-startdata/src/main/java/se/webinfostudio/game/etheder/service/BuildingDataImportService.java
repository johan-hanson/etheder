package se.webinfostudio.game.etheder.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.repository.building.BuildingDataRepository;

public class BuildingDataImportService {

	private static final Long START_ID = Long.valueOf(1L);

	@Inject
	private BuildingDataRepository buildingDataRepository;

	public void importData(final List<BuildingData> buildings) {
		try {
			final Optional<BuildingData> building = Optional.ofNullable(buildingDataRepository.findById(START_ID));
			if (!building.isPresent()) {
				buildings.forEach(buildingDataRepository::create);
			}
		} finally {
		}
	}
}
