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

import se.webinfostudio.game.etheder.dao.building.BuildingDataDAO;
import se.webinfostudio.game.etheder.dao.building.BuildingQueueDAO;
import se.webinfostudio.game.etheder.dao.player.CityDAO;
import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.core.UnitType;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
public class BuildingQueueServiceTest {

	@Mock
	private BuildingDataDAO buildingDataDAO;

	@Mock
	private BuildingQueueDAO buildingQueueDAO;

	@Mock
	private CityDAO cityDAO;

	@Mock
	private PlayerDAO playerDAO;

	@Mock
	private WalletService walletService;

	@InjectMocks
	private BuildingQueueService sut;

	@BeforeEach
	void beforeEach() {
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
		city.setPlayer(player.toRef());
		final BuildingQueue buildingQueue = createBuildingQueue(cityId, cityId, buildingDataId);

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(of(player));
		when(buildingDataDAO.findById(buildingDataId)).thenReturn(of(buildingData));

		final BuildingQueue result = sut.createBuildingQueue(buildingQueue, userId);

		assertThat(result.getBuilding().getId()).isEqualTo(buildingDataId);
		assertThat(result.getTicks()).isEqualTo(buildingData.getTicks());
		assertThat(result.getCity()).isEqualTo(city.toRef());
	}

	@Test
	void createBuilding_shouldThrowRuntimeException_whenCityAndPlayerValidationFails() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final Player player = createPlayer();
		final BuildingQueue buildingQueue = createBuildingQueue();

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(of(player));

		assertThatThrownBy(() -> sut.createBuildingQueue(buildingQueue, userId));
	}

	@Test
	void createBuilding_shouldThrowRuntimeException_whenCityNotFound() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final BuildingQueue buildingQueue = createBuildingQueue();

		when(cityDAO.findById(cityId)).thenReturn(empty());

		assertThatThrownBy(() -> sut.createBuildingQueue(buildingQueue, userId));
	}

	@Test
	void createBuilding_shouldThrowRuntimeException_whenPlayerNotFound() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final BuildingQueue buildingQueue = createBuildingQueue();

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(empty());

		assertThatThrownBy(() -> sut.createBuildingQueue(buildingQueue, userId));
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
