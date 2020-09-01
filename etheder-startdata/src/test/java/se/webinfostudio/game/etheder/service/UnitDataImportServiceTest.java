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

import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.repository.unit.UnitDataRepository;

/**
 *
 * @author Johan Hanson
 *
 */
public class UnitDataImportServiceTest {

	@InjectMocks
	private UnitDataImportService sut;

	@Mock
	private UnitDataRepository unitDataRepository;

	@Test
	public void importData_shouldNotSave_whenEntityExistInDB() {
		when(unitDataRepository.findById(Long.valueOf(1))).thenReturn(createUnitData());
		sut.importData(asList(createUnitData(), createUnitData()));
		verify(unitDataRepository, never()).create(any(UnitData.class));
	}

	@Test
	public void importData_shouldSave_whenNotExistInDB() {
		sut.importData(asList(createUnitData(), createUnitData()));
		verify(unitDataRepository, times(2)).create(any(UnitData.class));
	}

	@BeforeEach
	public void setup() {
		initMocks(this);
	}

	private UnitData createUnitData() {
		final UnitData unitData = new UnitData();
		unitData.setName("Test unit");
		unitData.setDescription("Test description of a great unit");
		return unitData;
	}

}
