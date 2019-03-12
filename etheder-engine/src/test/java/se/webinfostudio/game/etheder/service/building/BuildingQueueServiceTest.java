package se.webinfostudio.game.etheder.service.building;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.building.BuildingDataDAO;
import se.webinfostudio.game.etheder.dao.building.BuildingQueueDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.util.EntityTestFactory;
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

//    @Mock
//    private PlayerRepository playerRepository;

	@Mock
	private WalletService walletService;

	@InjectMocks
	private BuildingQueueService sut;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
	}

	@Test
	void createBuildingQueue() {
		final BuildingQueue buildingQueue = EntityTestFactory.createBuildingQueue();
//        when(playerRepository.update(any(Player.class))).thenReturn(new Player());
		when(buildingDataDAO.findById(anyLong())).thenReturn(createBuildingData());
		when(buildingQueueDAO.persist(buildingQueue)).thenReturn(buildingQueue);

		final BuildingQueue result = sut.createBuildingQueue(buildingQueue);

		assertThat(result.getTicks()).isEqualTo(buildingQueue.getBuilding().getTicks());
//		verify(walletService).pay(any(Player.class), any(BuildingData.class));
		verify(buildingQueueDAO).persist(buildingQueue);
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
