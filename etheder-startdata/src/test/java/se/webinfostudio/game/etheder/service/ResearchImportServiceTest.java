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

import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.repository.research.ResearchRepository;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchImportServiceTest {

	@InjectMocks
	private ResearchImportService sut;

	@Mock
	private ResearchRepository researchRepository;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
	}

	@Test
	void importData_shouldNotSave_whenEntityExistInDB() {
		when(researchRepository.findById(Long.valueOf(1))).thenReturn(createResearch());
		sut.importData(asList(createResearch(), createResearch()));
		verify(researchRepository, never()).create(any(Research.class));
	}

	@Test
	void importData_shouldSave_whenNotExistInDB() {
		sut.importData(asList(createResearch(), createResearch()));
		verify(researchRepository, times(2)).create(any(Research.class));
	}

	private Research createResearch() {
		final Research research = new Research();
		research.setName("Upgrade to level 2");
		research.setDescription("Upgrade the infantry to level 2");
		return research;
	}

}
