package se.webinfostudio.game.etheder.engine.service.building;

import static java.util.Arrays.asList;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuilding;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.engine.dao.building.BuildingDAO;
import se.webinfostudio.game.etheder.engine.dao.building.BuildingQueueDAO;
import se.webinfostudio.game.etheder.engine.dao.player.CityDAO;
import se.webinfostudio.game.etheder.engine.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 */
class BuildingQueueEngineServiceTest {

	@InjectMocks
	private BuildingQueueEngineService sut;

	@Mock
	private BuildingQueueDAO buildingQueueDAO;

	@Mock
	private BuildingDAO buildingDAO;

	@Mock
	private CityDAO cityDAO;

	@Mock
	private PlayerDAO playerDAO;

	@BeforeEach
	public void beforeEach() {
		initMocks(this);
		sut = new BuildingQueueEngineService(buildingQueueDAO, buildingDAO, cityDAO, playerDAO);

	}

	@Test
	public void updateAllQueuesAndBuildBuildings() {
		final City city1 = createCity();
		final City city2 = createCity();
		final BuildingQueue buildingQueue1 = createBuildingQueue(randomUUID(), city1.getId(), 1L);
		final BuildingQueue buildingQueue2 = createBuildingQueue(randomUUID(), city2.getId(), 2L);
		final Player player1 = createPlayer();
		final Player player2 = createPlayer();

		when(buildingQueueDAO.decreaseTicks()).thenReturn(5);
		when(buildingQueueDAO.findAllFinished()).thenReturn(
				asList(
						buildingQueue1,
						buildingQueue2));

		when(cityDAO.findByRef(new CityRef(city1.getId()))).thenReturn(city1);
		when(cityDAO.findByRef(new CityRef(city2.getId()))).thenReturn(city2);
		when(playerDAO.findByCity(new CityRef(city1.getId()))).thenReturn(of(player1));
		when(playerDAO.findByCity(new CityRef(city2.getId()))).thenReturn(of(player2));

		final Building building1 = createBuilding();
		final Building building2 = createBuilding(UUID.randomUUID(), "Stable");
		when(buildingDAO.createBuilding(buildingQueue1.getBuilding())).thenReturn(building1);
		when(buildingDAO.createBuilding(buildingQueue2.getBuilding())).thenReturn(building2);

		sut.updateAllQueuesAndBuildBuildings();

//		verify(playerDAO, times(2)).persist(any(Player.class));
//		verify(cityDAO, times(2)).persist(any(City.class));
//		verify(buildingQueueDAO, times(2)).remove(any(BuildingQueue.class));
	}

	@Test
	public void updateAllQueuesAndBuildBuildings_shouldDoNothing_whenDecreaseTicksReturnZero() {
		when(buildingQueueDAO.decreaseTicks()).thenReturn(0);

		sut.updateAllQueuesAndBuildBuildings();

		verify(buildingQueueDAO, never()).findAllFinished();
	}
}
