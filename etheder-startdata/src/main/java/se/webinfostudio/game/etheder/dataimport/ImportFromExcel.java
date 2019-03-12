package se.webinfostudio.game.etheder.dataimport;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.service.BuildingDataService;
import se.webinfostudio.game.etheder.service.ResearchService;
import se.webinfostudio.game.etheder.service.UnitDataService;

/**
 *
 * @author Johan Hanson
 */
public class ImportFromExcel {

	public static final String EXCEL_FILE_NAME = "StartData.xlsx";

	@Inject
	private BuildingDataService buildingDataService;

	@Inject
	private ImportBuildingData importBuildingData;

	@Inject
	private UnitDataService unitDataService;

	@Inject
	private ImportUnitData importUnitData;

	@Inject
	private ResearchService researchService;

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
