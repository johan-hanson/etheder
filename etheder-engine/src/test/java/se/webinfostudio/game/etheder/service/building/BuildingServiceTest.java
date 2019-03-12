package se.webinfostudio.game.etheder.service.building;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuilding;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.building.BuildingDAO;
import se.webinfostudio.game.etheder.entity.building.Building;

/**
 *
 * @author Johan Hanson
 */
public class BuildingServiceTest {

	@Mock
	private BuildingDAO buildingDAO;

	@InjectMocks
	private BuildingService sut;

	@Test
	public void findAll() {
		final Building b = createBuilding();

		when(buildingDAO.findAll()).thenReturn(Arrays.asList(b));

		final List<Building> l = sut.findAll();
		assertEquals(1, l.size());
	}

	/**
	 * .
	 */
	@Test
	public void findById() {
		final Building b = createBuilding();
		when(buildingDAO.findById(any(UUID.class))).thenReturn(b);
//		final Optional<Building> b2 = sut.findById(b.getId());
//		assertNotNull(b2);
//		assertTrue(b2.isPresent());
//		assertEquals(b.getId(), b2.get().getId());
	}

	/**
	 * .
	 */
	@Before
	public void setUp() {
		sut = new BuildingService();
		initMocks(this);
	}
}
