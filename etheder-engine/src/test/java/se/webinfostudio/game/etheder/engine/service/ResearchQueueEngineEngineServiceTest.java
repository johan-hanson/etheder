package se.webinfostudio.game.etheder.engine.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.engine.service.research.ResearchQueueEngineService;

/**
 *
 * @author Johan Hanson
 */
public class ResearchQueueEngineEngineServiceTest {

//	@Mock
//	private ResearchRepository researchRepository;
//
//	@Mock
//	private ResearchQueueRepository researchQueueRepository;
//
//	@Mock
//	private PlayerRepository playerRepository;

	@InjectMocks
	private ResearchQueueEngineService sut;

	@BeforeEach
	void setUp() {
//		sut = new ResearchQueueEngineService();
//		initMocks(this);
	}

	@Test
	void updateAllQueuesAndCreateResearches() {
//		when(researchQueueRepository.insertUpdateNamedQuery(anyString())).thenReturn(10);
//		final ResearchQueue rq1 = ethederTestFactory.createResearchQueue();
//		final ResearchQueue rq2 = ethederTestFactory.createResearchQueue(2L, 2L, 2L);
//		when(researchQueueRepository.findAllFinished()).thenReturn(Arrays.asList(rq1, rq2));
//
//		final Player p1 = ethederTestFactory.createPlayer();
//		final Player p2 = ethederTestFactory.createPlayer(2L, "Sweden");
//		when(playerRepository.findByRef(any(PlayerRef.class))).thenReturn(p1, p2);
//
//		final Research b1 = ethederTestFactory.createResearch();
//		final Research b2 = ethederTestFactory.createResearch(2L, "Stablehourses", UnitType.CAVALRY);
//		when(researchRepository.findByRef(any(ResearchRef.class))).thenReturn(b1, b2);
//
//		sut.updateAllQueuesAndCreateResearches();
//
//		verify(playerRepository, times(2)).update(any(Player.class));
//		verify(researchQueueRepository, times(2)).remove(any(ResearchQueue.class));
	}
}
