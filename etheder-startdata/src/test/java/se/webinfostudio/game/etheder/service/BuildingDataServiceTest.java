package se.webinfostudio.game.etheder.service;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.building.BuildingDataManualDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataServiceTest {

	@InjectMocks
	private BuildingDataService sut;

	@Mock
	private BuildingDataManualDAO buildingDataManualDAO;

	@BeforeEach
	public void setup() {
		initMocks(this);
	}

	@Test
	void importData_shouldNotSave_whenEntityExistInDB() {
		when(buildingDataManualDAO.findById(Long.valueOf(1))).thenReturn(Optional.of(createBuildingData()));
		sut.importData(asList(createBuildingData(), createBuildingData()));
		verify(buildingDataManualDAO, never()).persist(any(BuildingData.class));
	}

	@Test
	void importData_shouldSave_whenNotExistInDB() {
		when(buildingDataManualDAO.findById(Long.valueOf(1))).thenReturn(Optional.empty());
		sut.importData(asList(createBuildingData(), createBuildingData()));
		verify(buildingDataManualDAO, times(2)).persist(any(BuildingData.class));
	}

	private BuildingData createBuildingData() {
		final BuildingData buildingData = new BuildingData();
		buildingData.setName("Test building");
		buildingData.setDescription("Test description of a nice building");
		return buildingData;
	}
}
