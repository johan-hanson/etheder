package se.webinfostudio.game.etheder.service;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.unit.UnitDataManualDAO;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

/**
 *
 * @author Johan Hanson
 *
 */
public class UnitDataServiceTest {

	@InjectMocks
	private UnitDataService sut;

	@Mock
	private UnitDataManualDAO unitDataManualDAO;

	@Test
	public void importData_shouldNotSave_whenEntityExistInDB() {
		when(unitDataManualDAO.findById(Long.valueOf(1))).thenReturn(Optional.of(createUnitData()));
		sut.importData(asList(createUnitData(), createUnitData()));
		verify(unitDataManualDAO, never()).persist(any(UnitData.class));
	}

	@Test
	public void importData_shouldSave_whenNotExistInDB() {
		when(unitDataManualDAO.findById(Long.valueOf(1))).thenReturn(Optional.empty());
		sut.importData(asList(createUnitData(), createUnitData()));
		verify(unitDataManualDAO, times(2)).persist(any(UnitData.class));
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
