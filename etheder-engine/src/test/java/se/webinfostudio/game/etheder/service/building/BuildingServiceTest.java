package se.webinfostudio.game.etheder.service.building;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

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
import se.webinfostudio.game.etheder.dao.player.CityDAO;
import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.unit.UnitType;
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

	@Mock
	private CityDAO cityDAO;

	@Mock
	private PlayerDAO playerDAO;

	@Test
	void createBuilding() {
		final Long buildingDataId = 1L;
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final BuildingData buildingData = createBuildingData(buildingDataId, "Barracks", UnitType.INFANTRY);
		final Player player = createPlayer();
		city.setPlayer(player.toRef());

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(of(player));
		when(buildingDataDAO.findById(buildingDataId)).thenReturn(buildingData);

		final BuildingQueue result = sut.createBuilding(buildingDataId, cityId, userId);

		assertThat(result.getBuilding().getId()).isEqualTo(buildingDataId);
		assertThat(result.getTicks()).isEqualTo(buildingData.getTicks());
		assertThat(result.getCity()).isEqualTo(city.toRef());
	}

	@Test
	void createBuilding_shouldThrowRuntimeException_whenCityAndPlayerValidationFails() {
		final Long buildingDataId = 1L;
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final Player player = createPlayer();

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(of(player));

		assertThatThrownBy(() -> sut.createBuilding(buildingDataId, cityId, userId));
	}

	@Test
	void createBuilding_shouldThrowRuntimeException_whenCityNotFound() {
		final Long buildingDataId = 1L;
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();

		when(cityDAO.findById(cityId)).thenReturn(empty());

		assertThatThrownBy(() -> sut.createBuilding(buildingDataId, cityId, userId));
	}

	@Test
	void createBuilding_shouldThrowRuntimeException_whenPlayerNotFound() {
		final Long buildingDataId = 1L;
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(empty());

		assertThatThrownBy(() -> sut.createBuilding(buildingDataId, cityId, userId));
	}

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
