package se.webinfostudio.game.etheder.dataimport;

import static se.webinfostudio.game.etheder.dataimport.ImportFromExcel.EXCEL_FILE_NAME;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.apache.poi.ss.usermodel.Row;

import se.webinfostudio.game.etheder.entity.converters.UnitTypeConverter;
import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 *
 */
public class ImportResearch implements ImportData<Research> {

	private final ReadExcel readExcel;

	private final UnitTypeConverter converter;

	@Inject
	public ImportResearch(final ReadExcel readExcel) {
		this.readExcel = readExcel;
		converter = new UnitTypeConverter();
	}

	@Override
	public List<Research> getImports() throws DataImportException {
		final List<Research> list = new LinkedList<>();

		final Iterator<Row> rowIterator = readExcel.getExcelRows(EXCEL_FILE_NAME, "Research");

		boolean first = true;
//Get iterator to all cells of current row
		while (rowIterator.hasNext()) {
			final Row row = rowIterator.next();
			if (!first) {
				final Research r = new Research();
				r.setId(Double.valueOf(row.getCell(0).getNumericCellValue()).longValue());
				r.setName(row.getCell(1).getStringCellValue());
				r.setDescription(row.getCell(2).getStringCellValue());
				r.setTicks(Double.valueOf(row.getCell(3).getNumericCellValue()).intValue());
				r.setCostFood(Double.valueOf(row.getCell(4).getNumericCellValue()).longValue());
				r.setCostIron(Double.valueOf(row.getCell(5).getNumericCellValue()).longValue());
				r.setCostWood(Double.valueOf(row.getCell(6).getNumericCellValue()).longValue());
				r.setCostStone(Double.valueOf(row.getCell(7).getNumericCellValue()).longValue());
				r.setCostGold(Double.valueOf(row.getCell(8).getNumericCellValue()).longValue());
				r.setUnitType(converter.convertToEntityAttribute(row.getCell(9).getStringCellValue()));
				r.setLevel(Double.valueOf(row.getCell(10).getNumericCellValue()).intValue());
				list.add(r);
			} else {
				first = false;
			}
		}
		return list;
	}

}
