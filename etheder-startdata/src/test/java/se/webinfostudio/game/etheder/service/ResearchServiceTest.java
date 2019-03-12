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

import se.webinfostudio.game.etheder.dao.research.ResearchManualDAO;
import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchServiceTest {

	@InjectMocks
	private ResearchService sut;

	@Mock
	private ResearchManualDAO researchManualDAO;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
	}

	@Test
	void importData_shouldNotSave_whenEntityExistInDB() {
		when(researchManualDAO.findById(Long.valueOf(1))).thenReturn(Optional.of(createResearch()));
		sut.importData(asList(createResearch(), createResearch()));
		verify(researchManualDAO, never()).persist(any(Research.class));
	}

	@Test
	void importData_shouldSave_whenNotExistInDB() {
		when(researchManualDAO.findById(Long.valueOf(1))).thenReturn(Optional.empty());
		sut.importData(asList(createResearch(), createResearch()));
		verify(researchManualDAO, times(2)).persist(any(Research.class));
	}

	private Research createResearch() {
		final Research research = new Research();
		research.setName("Upgrade to level 2");
		research.setDescription("Upgrade the infantry to level 2");
		return research;
	}

}
