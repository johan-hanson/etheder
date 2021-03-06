package se.webinfostudio.game.etheder.dataimport;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.dataimport.ImportFromExcel.EXCEL_FILE_NAME;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.service.BuildingDataImportService;
import se.webinfostudio.game.etheder.service.ResearchImportService;
import se.webinfostudio.game.etheder.service.UnitDataImportService;

/**
 * Test if the excel file is in project
 *
 * @author Johan Hanson
 */
public class ImportFromExcelTest {

	@InjectMocks
	private ImportFromExcel sut;

	@Mock
	private BuildingDataImportService buildingDataService;

	@Mock
	private ImportBuildingData importBuildingData;

	@Mock
	private UnitDataImportService unitDataService;

	@Mock
	private ImportUnitData importUnitData;

	@Mock
	private ResearchImportService researchService;

	@Mock
	private ImportResearch importResearch;

	@BeforeEach
	public void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	void startImport() throws DataImportException {
		sut.startImport();

		verify(buildingDataService).importData(anyList());
		verify(unitDataService).importData(anyList());
		verify(researchService).importData(anyList());
	}

	@Test
	void testIfExcelFilesExist() {
		assertNotNull("Test excel-file missing",
				Thread.currentThread().getContextClassLoader().getResourceAsStream(EXCEL_FILE_NAME));
	}

}
