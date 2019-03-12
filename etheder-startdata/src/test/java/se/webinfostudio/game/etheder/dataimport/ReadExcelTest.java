package se.webinfostudio.game.etheder.dataimport;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Johan Hanson
 */
public class ReadExcelTest {

	@Test
	void testBuilding() throws DataImportException {
		final ReadExcel reader = new ReadExcel();

		final Iterator<Row> rows = reader.getExcelRows(ImportFromExcel.EXCEL_FILE_NAME, "Buildings");

		assertTrue(rows.hasNext());
	}

	@Test
	void testFileNotFound() throws DataImportException {
		final ReadExcel reader = new ReadExcel();

		assertThrows(DataImportException.class, () -> reader.getExcelRows("no file", "Buildings"));
	}
}
