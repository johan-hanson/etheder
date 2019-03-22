package se.webinfostudio.game.etheder.service.unit;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

/**
 *
 * @author Johan Hanson
 */
public class UnitServiceTest {

//    @Mock
//    private UnitRepository unitRepository;

	@InjectMocks
	private UnitService sut;

	/**
	 * Test of findById method, of class UnitService.
	 */
	@Test
	public void findById() {
//		final Unit u = ethederTestFactory.createUnit();
//		when(unitRepository.findById(Matchers.anyLong())).thenReturn(u);
//		final Unit u2 = sut.findById(u.getId());
//		Assert.assertEquals(u.getId(), u2.getId());
	}

	/**
	 * Test of findAll method, of class UnitService.
	 */
	@Test
	void findAll() {
//		final Unit u = ethederTestFactory.createUnit();
//
//		when(unitRepository.findAll()).thenReturn(Arrays.asList(u));
//
//		final List<Unit> l = sut.findAll();
//		Assert.assertEquals(1, l.size());
	}

	/**
	 * Test of save method, of class UnitService.
	 */
	@Test
	void save() {
//        final Unit b1 = ethederTestFactory.createUnit();
//        final Unit b2 = ethederTestFactory.createUnit(2L, "Cavlry", UnitType.CAVALRY);
//
//        final List<Unit> result = sut.save(Arrays.asList(b1, b2));
//        verify(unitRepository, times(2)).create(Matchers.any(Unit.class));
//        Assert.assertEquals(2, result.size());
	}

	@BeforeEach
	void setUp() {
		sut = new UnitService();
		initMocks(this);
	}

}
