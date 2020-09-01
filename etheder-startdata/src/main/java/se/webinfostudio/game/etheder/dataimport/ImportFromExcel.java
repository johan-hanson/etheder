package se.webinfostudio.game.etheder.dataimport;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.service.BuildingDataImportService;
import se.webinfostudio.game.etheder.service.ResearchImportService;
import se.webinfostudio.game.etheder.service.UnitDataImportService;

/**
 *
 * @author Johan Hanson
 */
public class ImportFromExcel {

	public static final String EXCEL_FILE_NAME = "StartData.xlsx";

	@Inject
	private BuildingDataImportService buildingDataService;

	@Inject
	private ImportBuildingData importBuildingData;

	@Inject
	private UnitDataImportService unitDataService;

	@Inject
	private ImportUnitData importUnitData;

	@Inject
	private ResearchImportService researchService;

	@Inject
	private ImportResearch importResearch;

	public ImportFromExcel() {
	}

	public void startImport() throws DataImportException {
		buildingDataService.importData(importBuildingData.getImports());
		unitDataService.importData(importUnitData.getImports());
		researchService.importData(importResearch.getImports());
	}

}
