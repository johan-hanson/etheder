package se.webinfostudio.game.etheder.engine.service.research;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearch;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearchQueue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.core.UnitType;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;
import se.webinfostudio.game.etheder.repository.research.ResearchQueueRepository;
import se.webinfostudio.game.etheder.repository.research.ResearchRepository;

public class ResearchQueueEngineServiceTest {

	@InjectMocks
	private ResearchQueueEngineService sut;

	@Mock
	private ResearchRepository researchRepository;

	@Mock
	private ResearchQueueRepository researchQueueRepository;

	@Mock
	private PlayerRepository playerRepository;

	@BeforeEach
	public void beforeEach() {
		initMocks(this);
	}

	@Test
	public void updateAllQueuesAndCreateResearches() {
		final Player player1 = createPlayer();
		final Player player2 = createPlayer();
		final ResearchQueue researchQueue1 = createResearchQueue(randomUUID(), player1.getId(), 1L);
		final ResearchQueue researchQueue2 = createResearchQueue(randomUUID(), player2.getId(), 2L);
		final Research research1 = createResearch(1L, "Barraks", 1, UnitType.INFANTRY);
		final Research research2 = createResearch(2L, "Stable", 2, UnitType.CAVALRY);

		when(researchQueueRepository.decreaseTicks()).thenReturn(2);
		when(researchQueueRepository.findAllFinished()).thenReturn(
				asList(
						researchQueue1,
						researchQueue2));

		when(playerRepository.findById(player1.getId())).thenReturn(player1);
		when(playerRepository.findById(player2.getId())).thenReturn(player2);
		when(researchRepository.findById(researchQueue1.getResearchId())).thenReturn(research1);
		when(researchRepository.findById(researchQueue2.getResearchId())).thenReturn(research2);

		sut.updateAllQueuesAndCreateResearches();

		verify(playerRepository, times(2)).update(any(Player.class));
		verify(researchQueueRepository, times(2)).remove(any(UUID.class));
	}

	@Test
	public void updateAllQueuesAndCreateResearches_shouldDoNothing_whenDecreaseTicksReturnZero() {
		when(researchQueueRepository.decreaseTicks()).thenReturn(0);

		sut.updateAllQueuesAndCreateResearches();

		verify(researchQueueRepository, never()).findAllFinished();
	}

}
