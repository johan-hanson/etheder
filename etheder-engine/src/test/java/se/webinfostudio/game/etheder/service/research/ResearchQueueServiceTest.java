package se.webinfostudio.game.etheder.service.research;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearch;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.dao.research.ResearchDAO;
import se.webinfostudio.game.etheder.dao.research.ResearchQueueDAO;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.entity.util.EntityTestFactory;
import se.webinfostudio.game.etheder.service.WalletService;

/**
 *
 * @author Johan Hanson
 */
public class ResearchQueueServiceTest {

	@Mock
	private ResearchDAO researchDAO;

	@Mock
	private ResearchQueueDAO researchQueueDAO;

	@Mock
	private PlayerDAO playerDAO;

	@Mock
	private WalletService walletService;

	@InjectMocks
	private ResearchQueueService sut;

	@BeforeEach
	public void setUp() {
		sut = new ResearchQueueService();
		initMocks(this);
	}

	@Test
	void createResearchQueue_shouldThrowRuntimeException_whenPlayerNotFound() {
		final UUID userId = randomUUID();
		final ResearchQueue researchQueue = EntityTestFactory.createResearchQueue();

		when(playerDAO.findByUserId(userId)).thenReturn(empty());

		assertThatThrownBy(() -> sut.createResearchQueue(researchQueue, userId));
	}

	@Test
	void createResearchQueue_shouldThrowRuntimeException_whenPlayerValidationFails() {
		final UUID userId = randomUUID();
		final Player player = createPlayer();
		final ResearchQueue researchQueue = EntityTestFactory.createResearchQueue();

		when(playerDAO.findByUserId(userId)).thenReturn(of(player));

		assertThatThrownBy(() -> sut.createResearchQueue(researchQueue, userId));
	}

	@Test
	void createReserchQueue() {
		final Long researchId = 1L;
		final UUID userId = randomUUID();
		final Research research = createResearch();
		final Player player = createPlayer();
		final ResearchQueue researchQueue = EntityTestFactory.createResearchQueue();
		researchQueue.setPlayer(player.toRef());

		when(playerDAO.findByUserId(userId)).thenReturn(of(player));
		when(researchDAO.findById(researchId)).thenReturn(of(research));

		final ResearchQueue result = sut.createResearchQueue(researchQueue, userId);

		assertThat(result.getResearch().getId()).isEqualTo(researchId);
		assertThat(result.getTicks()).isEqualTo(research.getTicks());
		assertThat(result.getPlayer().getId()).isEqualTo(player.getId());
	}

	@Test
	void findByPlayer() {
//        final ResearchQueue rq1 = ethederTestFactory.createResearchQueue();
//        final ResearchQueue rq2 = ethederTestFactory.createResearchQueue(2L, 2L, 2L);
//        when(researchQueueRepository.findByPlayer(any(Player.class))).thenReturn(Arrays.asList(rq1, rq2));
//        final List<ResearchQueue> list = sut.findByPlayer(ethederTestFactory.createPlayer());
//        Assert.assertEquals(2, list.size());
	}

}
