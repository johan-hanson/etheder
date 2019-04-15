package se.webinfostudio.game.etheder.service.research;

import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.unit.UnitType.CAVALRY;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearch;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.util.EntityTestFactory;

/**
 *
 * @author Johan Hanson
 */
public class ResearchServiceTest {

//    @Mock
//    private ResearchRepository researchRepository;

	@InjectMocks
	private ResearchService sut;

	/**
	 * Test of findAll method, of class ResearchService.
	 */
	@Test
	void findAll() {
		final Research r = EntityTestFactory.createResearch();

//		when(researchRepository.findAll()).thenReturn(Arrays.asList(r));

		final List<Research> l = sut.findAll();
//		Assert.assertEquals(1, l.size());
	}

	/**
	 * Test of findById method, of class ResearchService.
	 */
	@Test
	void findById() {
		final Research r = EntityTestFactory.createResearch();
//		when(researchRepository.findById(Matchers.anyLong())).thenReturn(r);
//		final Research r2 = sut.findById(r.getId());
//		Assert.assertEquals(r.getId(), r2.getId());
	}

	/**
	 * Test of save method, of class ResearchService.
	 */
	@Test
	void save() {
		final Research r1 = createResearch();
		final Research r2 = EntityTestFactory.buildResearch()
				.withId(1L)
				.withName("Stablehourses")
				.withUnitType(CAVALRY)
				.build();

		final List<Research> result = sut.save(Arrays.asList(r1, r2));
//		verify(researchRepository, times(2)).create(Matchers.any(Research.class));
//		Assert.assertEquals(2, result.size());
	}

	/**
	 * .
	 */
	@BeforeEach
	void setUp() {
		sut = new ResearchService();
		initMocks(this);
	}

}
