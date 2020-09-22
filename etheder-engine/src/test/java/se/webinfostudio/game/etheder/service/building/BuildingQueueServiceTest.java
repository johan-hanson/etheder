package se.webinfostudio.game.etheder.service.building;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
import se.webinfostudio.game.etheder.repository.player.CityRepository;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
public class BuildingQueueServiceTest {

	@Mock
	private BuildingDataRepository buildingDataRepository;

	@Mock
	private BuildingQueueRepository buildingQueueRepository;

	@Mock
	private CityRepository cityRepository;

	@Mock
	private PlayerRepository playerRepository;

	@Mock
	private WalletService walletService;

	@InjectMocks
	private BuildingQueueService sut;

	@BeforeEach
	void beforeEach() {
		sut = new BuildingQueueService();
		initMocks(this);
	}

	@Test
	void createBuilding() {
		final Long buildingDataId = 1L;
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final BuildingData buildingData = createBuildingData(buildingDataId, "Barracks", UnitType.INFANTRY);
		final Player player = createPlayer();
		city.setPlayerId(player.toRef().getId());
		final BuildingQueue buildingQueue = createBuildingQueue(cityId, cityId, buildingDataId);

		when(cityRepository.findById(cityId)).thenReturn(city);
		when(playerRepository.findByUserId(userId)).thenReturn(of(player));
		when(buildingDataRepository.findById(buildingDataId)).thenReturn(buildingData);

		final BuildingQueue result = sut.createBuildingQueue(buildingQueue, userId);

		assertThat(result.getBuildingId()).isEqualTo(buildingDataId);
		assertThat(result.getTicks()).isEqualTo(buildingData.getTicks());
		assertThat(result.getCityId()).isEqualTo(city.toRef().getId());
	}

	@Test
	void createBuilding_shouldThrowRuntimeException_whenCityAndPlayerValidationFails() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final Player player = createPlayer();
		final BuildingQueue buildingQueue = createBuildingQueue();

		when(cityRepository.findById(cityId)).thenReturn(city);
		when(playerRepository.findByUserId(userId)).thenReturn(of(player));

		assertThatThrownBy(() -> sut.createBuildingQueue(buildingQueue, userId)).isInstanceOf(RuntimeException.class);
	}

	@Test
	void createBuilding_shouldThrowRuntimeException_whenPlayerNotFound() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final BuildingQueue buildingQueue = createBuildingQueue();

		when(cityRepository.findById(cityId)).thenReturn(city);
		when(playerRepository.findByUserId(userId)).thenReturn(empty());

		assertThatThrownBy(() -> sut.createBuildingQueue(buildingQueue, userId)).isInstanceOf(RuntimeException.class);
	}

	@Test
	void findByCity() {
//        final BuildingQueue bq1 = ethederTestFactory.createBuildingQueue();
//        final BuildingQueue bq2 = ethederTestFactory.createBuildingQueue(2L, 2L, 2L);
//        when(buildingQueueRepository.findByCity(any(City.class))).thenReturn(Arrays.asList(bq1, bq2));
//        final List<BuildingQueue> list = sut.findByCity(ethederTestFactory.createCity());
//        Assert.assertEquals(2, list.size());
	}

}
