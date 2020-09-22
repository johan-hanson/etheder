package se.webinfostudio.game.etheder.service.unit;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static se.webinfostudio.game.etheder.entity.core.UnitType.INFANTRY;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUnitData;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import se.webinfostudio.game.etheder.dao.player.CityDAO;
import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.dao.unit.UnitDataDAO;
import se.webinfostudio.game.etheder.engine.dao.unit.UnitQueueDAO;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;
import se.webinfostudio.game.etheder.entity.util.EntityTestFactory;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
public class UnitQueueServiceTest {

	@Mock
	private CityDAO cityDAO;

	@Mock
	private PlayerDAO playerDAO;

	@Mock
	private UnitDataDAO unitDataDAO;

	@Mock
	private UnitQueueDAO unitQueueDAO;

	@Mock
	private WalletService walletService;

	@InjectMocks
	private UnitQueueService sut;

	@Test
	void createUnit_shouldThrowRuntimeException_whenPlayerNotFound() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final UnitQueue unitQueue = EntityTestFactory.createUnitQueue();

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(empty());

		assertThatThrownBy(() -> sut.createUnitQueue(unitQueue, userId));
	}

	@Test
	void createUnitQueue() {
		final Long unitDataId = 1L;
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final UnitData unitData = createUnitData("Swordsman", INFANTRY);
		final Player player = createPlayer();
		city.setPlayerId(player.getId());
		final UnitQueue unitQueue = EntityTestFactory.createUnitQueue(randomUUID(), cityId, unitDataId);

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(of(player));
		when(unitDataDAO.findById(unitDataId)).thenReturn(of(unitData));

		final UnitQueue result = sut.createUnitQueue(unitQueue, userId);

		assertThat(result.getUnit().getId()).isEqualTo(unitDataId);
		assertThat(result.getTicks()).isEqualTo(unitData.getTicks());
		assertThat(result.getCity()).isEqualTo(city.toRef());
	}

	@Test
	void createUnitQueue_shouldThrowRuntimeException_whenCityAndPlayerValidationFails() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final City city = createCity(cityId, "Paris");
		final Player player = createPlayer();
		final UnitQueue unitQueue = EntityTestFactory.createUnitQueue();

		when(cityDAO.findById(cityId)).thenReturn(of(city));
		when(playerDAO.findByUserId(userId)).thenReturn(of(player));

		assertThatThrownBy(() -> sut.createUnitQueue(unitQueue, userId));
	}

	@Test
	void createUnitQueue_shouldThrowRuntimeException_whenCityNotFound() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final UnitQueue unitQueue = EntityTestFactory.createUnitQueue();

		when(cityDAO.findById(cityId)).thenReturn(empty());

		assertThatThrownBy(() -> sut.createUnitQueue(unitQueue, userId));
	}

	@Test
	void findByPlayer() {
//        final UnitQueue uq1 = ethederTestFactory.createUnitQueue();
//        final UnitQueue uq2 = ethederTestFactory.createUnitQueue(2L, 2L, 2L);
//        when(unitQueueRepository.findByCity(any(City.class))).thenReturn(Arrays.asList(uq1, uq2));
//        final List<UnitQueue> list = sut.findByCity(ethederTestFactory.createCity());
//        Assert.assertEquals(2, list.size());
	}

	@BeforeEach
	void setUp() throws Exception {
		sut = new UnitQueueService();
		MockitoAnnotations.initMocks(this);
	}

}
