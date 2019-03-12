package se.webinfostudio.game.etheder.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import io.dropwizard.hibernate.UnitOfWork;
import se.webinfostudio.game.etheder.dao.building.BuildingDataManualDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

public class BuildingDataService {

	@Inject
	private BuildingDataManualDAO buildingDataManualDAO;

	@UnitOfWork
	public void importData(final List<BuildingData> buildings) {
		try {
			final Optional<BuildingData> building = buildingDataManualDAO.findById(Long.valueOf(1));
			if (!building.isPresent()) {
				buildings.forEach(buildingDataManualDAO::persist);
			}
		} finally {
			buildingDataManualDAO.closeSession();
		}
	}
}
