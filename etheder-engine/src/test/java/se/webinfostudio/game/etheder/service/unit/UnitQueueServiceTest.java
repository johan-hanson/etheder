package se.webinfostudio.game.etheder.service.unit;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import se.webinfostudio.game.etheder.entity.util.EntityTestFactory;

/**
 *
 * @author Johan Hanson
 */
public class UnitQueueServiceTest {

//    @Mock
//    private UnitQueueRepository unitQueueRepository;

	@InjectMocks
	private UnitQueueService sut;

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

	@Test
	void train() {
		sut.train(EntityTestFactory.createUnitData(), UUID.randomUUID(), UUID.randomUUID());
//        verify(unitQueueRepository).create(any(UnitQueue.class));
	}
}
