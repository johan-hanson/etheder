package se.webinfostudio.game.etheder.dataimport;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.dataimport.ImportFromExcel.EXCEL_FILE_NAME;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

/**
 *
 * @author Johan Hanson
 *
 */
public class ImportDataTest {

	@Mock
	private ReadExcel readExcel;

	@BeforeEach
	void beforeEach() throws DataImportException {
		initMocks(this);

		final Row row = mock(Row.class);
		final Cell cell = mock(Cell.class);
		when(row.getCell(anyInt())).thenReturn(cell);
		when(cell.getNumericCellValue()).thenReturn(100d);
		when(cell.getStringCellValue()).thenReturn("Name", "Description", "I");

		when(readExcel.getExcelRows(EXCEL_FILE_NAME, "Research")).thenReturn(asList(row, row, row).iterator());
	}
}
