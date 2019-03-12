package se.webinfostudio.game.etheder.dataimport;

import java.io.IOException;
import java.util.Iterator;

import javax.inject.Named;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Johan Hanson
 */
@Named
public class ReadExcel {

	/**
	 * Gets the rows from the excel-file
	 *
	 * @param fileName
	 * @param sheetName
	 * @return
	 * @throws ethederException if the file does not exist or the file can't be read
	 */
	protected Iterator<Row> getExcelRows(final String fileName, final String sheetName) throws DataImportException {
		try {
			// Get the workbook instance for XLS file
			final XSSFWorkbook workbook = new XSSFWorkbook(
					Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));

			// Get first sheet from the workbook
			final XSSFSheet sheet = workbook.getSheet(sheetName);

			// Get iterator to all the rows in current sheet
			return sheet.iterator();

		} catch (NullPointerException | IOException fnfe) {
			throw new DataImportException(fnfe);
		}

	}
}
