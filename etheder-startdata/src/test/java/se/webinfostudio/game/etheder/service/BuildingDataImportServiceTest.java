package se.webinfostudio.game.etheder.service;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.repository.building.BuildingDataRepository;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataImportServiceTest {

	@InjectMocks
	private BuildingDataImportService sut;

	@Mock
	private BuildingDataRepository buildingDataRepository;

	@BeforeEach
	void setup() {
		initMocks(this);
	}

	@Test
	void importData_shouldNotSave_whenEntityExistInDB() {
		when(buildingDataRepository.findById(Long.valueOf(1))).thenReturn(createBuildingData());
		sut.importData(asList(createBuildingData(), createBuildingData()));
		verify(buildingDataRepository, never()).create(any(BuildingData.class));
	}

	@Test
	void importData_shouldSave_whenNotExistInDB() {
		sut.importData(asList(createBuildingData(), createBuildingData()));
		verify(buildingDataRepository, times(2)).create(any(BuildingData.class));
	}

	private BuildingData createBuildingData() {
		final BuildingData buildingData = new BuildingData();
		buildingData.setName("Test building");
		buildingData.setDescription("Test description of a nice building");
		return buildingData;
	}
}
