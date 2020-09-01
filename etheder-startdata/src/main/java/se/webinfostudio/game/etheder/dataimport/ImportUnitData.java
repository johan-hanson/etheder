package se.webinfostudio.game.etheder.dataimport;

import static se.webinfostudio.game.etheder.dataimport.ImportFromExcel.EXCEL_FILE_NAME;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.ss.usermodel.Row;

import se.webinfostudio.game.etheder.entity.converters.UnitTypeConverter;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

/**
 *
 * @author Johan Hanson
 *
 */
public class ImportUnitData implements ImportData<UnitData> {

	private final ReadExcel readExcel;

	private final UnitTypeConverter converter;

	@Inject
	public ImportUnitData(final ReadExcel readExcel) {
		this.readExcel = readExcel;
		converter = new UnitTypeConverter();
	}

	@Override
	public List<UnitData> getImports() throws DataImportException {
		final List<UnitData> list = new LinkedList<>();

		final Iterator<Row> rowIterator = readExcel.getExcelRows(EXCEL_FILE_NAME, "Units");

		boolean first = true;
//Get iterator to all cells of current row
		while (rowIterator.hasNext()) {
			final Row row = rowIterator.next();
			if (!first) {
				final UnitData unitData = new UnitData();
				unitData.setId(Double.valueOf(row.getCell(0).getNumericCellValue()).longValue());
				unitData.setName(row.getCell(1).getStringCellValue());
				unitData.setDescription(row.getCell(2).getStringCellValue());
				unitData.setTicks(Double.valueOf(row.getCell(3).getNumericCellValue()).intValue());
				unitData.setCostFood(Double.valueOf(row.getCell(4).getNumericCellValue()).longValue());
				unitData.setCostIron(Double.valueOf(row.getCell(5).getNumericCellValue()).longValue());
				unitData.setCostWood(Double.valueOf(row.getCell(6).getNumericCellValue()).longValue());
				unitData.setCostStone(Double.valueOf(row.getCell(7).getNumericCellValue()).longValue());
				unitData.setCostGold(Double.valueOf(row.getCell(8).getNumericCellValue()).longValue());
				unitData.setUnitType(converter.convertToEntityAttribute(row.getCell(9).getStringCellValue()));
				unitData.setLevel(Double.valueOf(row.getCell(10).getNumericCellValue()).intValue());
				unitData.setAttack(Double.valueOf(row.getCell(11).getNumericCellValue()).intValue());
				unitData.setDefensive(Double.valueOf(row.getCell(12).getNumericCellValue()).intValue());
//				unitData.setArmour(Double.valueOf(row.getCell(13).getNumericCellValue()).intValue());
//				unitData.setSpeed(Double.valueOf(row.getCell(14).getNumericCellValue()).intValue());
//				unitData.setHealth(Double.valueOf(row.getCell(15).getNumericCellValue()).intValue());
				list.add(unitData);
			} else {
				first = false;
			}
		}
		return list;
	}

}
