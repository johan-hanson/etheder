package se.webinfostudio.game.etheder.engine.service.building;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.core.UnitType;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.repository.building.BuildingDataRepository;
import se.webinfostudio.game.etheder.repository.building.BuildingQueueRepository;
import se.webinfostudio.game.etheder.repository.building.BuildingRepository;
import se.webinfostudio.game.etheder.repository.player.CityRepository;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;

/**
 *
 * @author Johan Hanson
 */
class BuildingQueueEngineServiceTest {

	@InjectMocks
	private BuildingQueueEngineService sut;

	@Mock
	private BuildingDataRepository buildingDataRepository;

	@Mock
	private BuildingQueueRepository buildingQueueRepository;

	@Mock
	private BuildingRepository buildingRepository;

	@Mock
	private CityRepository cityRepository;

	@Mock
	private PlayerRepository playerRepository;

	@BeforeEach
	public void beforeEach() {
		initMocks(this);
	}

	@Test
	public void updateAllQueuesAndBuildBuildings() {
		final City city1 = createCity();
		final City city2 = createCity();
		final BuildingQueue buildingQueue1 = createBuildingQueue(randomUUID(), city1.getId(), 1L);
		final BuildingQueue buildingQueue2 = createBuildingQueue(randomUUID(), city2.getId(), 2L);
		final Player player1 = createPlayer();
		final Player player2 = createPlayer();
		final BuildingData buildingData1 = createBuildingData(1L, "Barraks", UnitType.INFANTRY);
		final BuildingData buildingData2 = createBuildingData(2L, "Stable", UnitType.CAVALRY);

		when(buildingQueueRepository.decreaseTicks()).thenReturn(5);
		when(buildingQueueRepository.findAllFinished()).thenReturn(
				asList(
						buildingQueue1,
						buildingQueue2));

		when(cityRepository.findById(city1.getId())).thenReturn(city1);
		when(cityRepository.findById(city2.getId())).thenReturn(city2);
		when(playerRepository.findById(city1.getPlayerId())).thenReturn(player1);
		when(playerRepository.findById(city2.getPlayerId())).thenReturn(player2);
		when(buildingDataRepository.findById(buildingQueue1.getBuildingId())).thenReturn(buildingData1);
		when(buildingDataRepository.findById(buildingQueue2.getBuildingId())).thenReturn(buildingData2);

		sut.updateAllQueuesAndBuildBuildings();

		verify(playerRepository, times(2)).update(any(Player.class));
		verify(cityRepository, times(2)).update(any(City.class));
		verify(buildingQueueRepository, times(2)).remove(any(UUID.class));
	}

	@Test
	public void updateAllQueuesAndBuildBuildings_shouldDoNothing_whenDecreaseTicksReturnZero() {
		when(buildingQueueRepository.decreaseTicks()).thenReturn(0);

		sut.updateAllQueuesAndBuildBuildings();

		verify(buildingQueueRepository, never()).findAllFinished();
	}
}
