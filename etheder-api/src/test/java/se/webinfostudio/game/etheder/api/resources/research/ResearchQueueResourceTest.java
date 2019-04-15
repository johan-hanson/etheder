package se.webinfostudio.game.etheder.api.resources.research;

import static java.util.UUID.randomUUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearchQueue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import se.webinfostudio.game.etheder.api.model.research.ResearchQueueModel;
import se.webinfostudio.game.etheder.api.transformer.research.ResearchQueueModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.research.ResearchQueueTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.service.research.ResearchQueueService;

public class ResearchQueueResourceTest {

	@InjectMocks
	private ResearchQueueResource sut;

	@Mock
	private ResearchQueueService researchQueueService;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		final ResearchQueueTransformer researchQueueTransformer = new ResearchQueueTransformer();
		final ResearchQueueModelTransformer researchQueueModelTransformer = new ResearchQueueModelTransformer();
		sut = new ResearchQueueResource(objectMapper, researchQueueService, researchQueueTransformer,
				researchQueueModelTransformer);

		// Fix for AbstractResource
		when(objectMapper.createObjectNode()).thenReturn(new ObjectNode(new JsonNodeFactory(false)));
		when(objectMapper.getFactory()).thenReturn(new JsonFactory());
	}

	@Test
	void create() {
		final UUID playerId = randomUUID();
		final UUID userId = randomUUID();
		final AuthUser user = AuthUser.newBuilder().withUserId(userId.toString()).build();
		final ResearchQueueModel buildingQueueModel = ResearchQueueModel.newBuilder()
				.withResearchId(1L)
				.withPlayerId(playerId.toString())
				.build();

		when(researchQueueService.createResearchQueue(any(ResearchQueue.class), eq(userId)))
				.thenReturn(createResearchQueue());

		sut.create(buildingQueueModel, user);

		verify(researchQueueService).createResearchQueue(any(ResearchQueue.class), eq(userId));
	}

}
