package se.webinfostudio.game.etheder.service.building;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.building.BuildingDAO;
import se.webinfostudio.game.etheder.dao.building.BuildingDataDAO;
import se.webinfostudio.game.etheder.dao.building.BuildingQueueDAO;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.util.EntityTestFactory;

/**
 *
 * @author Johan Hanson
 */
public class BuildingServiceTest {

	@InjectMocks
	private BuildingService sut;

	@Mock
	private BuildingDAO buildingDAO;

	@Mock
	private BuildingDataDAO buildingDataDAO;

	@Mock
	private BuildingQueueDAO buildingQueueDAO;

	@Test
	void findAll() {
		final Building b = EntityTestFactory.createBuilding();

		when(buildingDAO.findAll()).thenReturn(Arrays.asList(b));

		final List<Building> l = sut.findAll();
		assertEquals(1, l.size());
	}

	@Test
	void findById() {
		final Building b = EntityTestFactory.createBuilding();
		when(buildingDAO.findById(any(UUID.class))).thenReturn(b);
//		final Optional<Building> b2 = sut.findById(b.getId());
//		assertNotNull(b2);
//		assertTrue(b2.isPresent());
//		assertEquals(b.getId(), b2.get().getId());
	}

	@BeforeEach
	void setUp() {
		sut = new BuildingService();
		initMocks(this);
	}
}
