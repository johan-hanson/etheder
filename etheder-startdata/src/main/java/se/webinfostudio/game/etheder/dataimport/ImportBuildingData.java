package se.webinfostudio.game.etheder.dataimport;

import static se.webinfostudio.game.etheder.dataimport.ImportFromExcel.EXCEL_FILE_NAME;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.ss.usermodel.Row;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.converters.UnitTypeConverter;

/**
 *
 * @author Johan Hanson
 *
 */
public class ImportBuildingData implements ImportData<BuildingData> {

	private final ReadExcel readExcel;

	private final UnitTypeConverter converter;

	@Inject
	public ImportBuildingData(final ReadExcel readExcel) {
		this.readExcel = readExcel;
		converter = new UnitTypeConverter();
	}

	@Override
	public List<BuildingData> getImports() throws DataImportException {
		final List<BuildingData> list = new LinkedList<>();

		final Iterator<Row> rowIterator = readExcel.getExcelRows(EXCEL_FILE_NAME, "Buildings");

		boolean first = true;
		// Get iterator to all cells of current row
		while (rowIterator.hasNext()) {
			final Row row = rowIterator.next();
			if (!first) {
				final BuildingData b = new BuildingData();
				b.setId(Double.valueOf(row.getCell(0).getNumericCellValue()).longValue());
				b.setName(row.getCell(1).getStringCellValue());
				b.setDescription(row.getCell(2).getStringCellValue());
				b.setTicks(Double.valueOf(row.getCell(3).getNumericCellValue()).intValue());
				b.setCostFood(Double.valueOf(row.getCell(4).getNumericCellValue()).intValue());
				b.setCostIron(Double.valueOf(row.getCell(5).getNumericCellValue()).intValue());
				b.setCostWood(Double.valueOf(row.getCell(6).getNumericCellValue()).intValue());
				b.setCostStone(Double.valueOf(row.getCell(7).getNumericCellValue()).intValue());
				b.setCostGold(Double.valueOf(row.getCell(8).getNumericCellValue()).intValue());
				b.setUnitType(converter.convertToEntityAttribute(row.getCell(9).getStringCellValue()));
				b.setMaxNumber(Double.valueOf(row.getCell(10).getNumericCellValue()).intValue());
				b.setPopulationCapacity(Double.valueOf(row.getCell(11).getNumericCellValue()).intValue());
				list.add(b);
			} else {
				first = false;
			}
		}
		return list;
	}

}
