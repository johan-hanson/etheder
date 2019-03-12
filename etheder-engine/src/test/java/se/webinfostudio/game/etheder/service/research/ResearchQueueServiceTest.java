package se.webinfostudio.game.etheder.service.research;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author JOHA
 */
public class ResearchQueueServiceTest {

//    @Mock
//    private ResearchQueueRepository researchQueueRepository;
//
//    @Mock
//    private PlayerRepository playerRepository;

	@Mock
	private WalletService walletService;

	@InjectMocks
	private ResearchQueueService sut;

	/**
	 * .
	 */
	@Test
	public void findByPlayer() {
//        final ResearchQueue rq1 = ethederTestFactory.createResearchQueue();
//        final ResearchQueue rq2 = ethederTestFactory.createResearchQueue(2L, 2L, 2L);
//        when(researchQueueRepository.findByPlayer(any(Player.class))).thenReturn(Arrays.asList(rq1, rq2));
//        final List<ResearchQueue> list = sut.findByPlayer(ethederTestFactory.createPlayer());
//        Assert.assertEquals(2, list.size());
	}

	/**
	 * .
	 */
	@Test
	public void research() {
//        when(playerRepository.update(any(Player.class))).thenReturn(new Player());
//
//        sut.research(ethederTestFactory.createResearch(), createPlayer());
//        verify(walletService).pay(any(Player.class), any(Research.class));
//        verify(researchQueueRepository).create(any(ResearchQueue.class));
	}

	/**
	 * .
	 */
	@Before
	public void setUp() {
		sut = new ResearchQueueService();
		initMocks(this);
	}

}
