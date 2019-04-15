package se.webinfostudio.game.etheder.api.resources.building;

import static java.util.UUID.randomUUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.service.building.BuildingQueueService;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueResourceTest {

	@InjectMocks
	private BuildingQueueResource sut;

	@Mock
	private BuildingQueueService buildingQueueService;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		final BuildingQueueTransformer buildingQueueTransformer = new BuildingQueueTransformer();
		final BuildingQueueModelTransformer buildingQueueModelTransformer = new BuildingQueueModelTransformer();
		sut = new BuildingQueueResource(objectMapper, buildingQueueService, buildingQueueTransformer,
				buildingQueueModelTransformer);

		// Fix for AbstractResource
		when(objectMapper.createObjectNode()).thenReturn(new ObjectNode(new JsonNodeFactory(false)));
		when(objectMapper.getFactory()).thenReturn(new JsonFactory());
	}

	@Test
	void create() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final AuthUser user = AuthUser.newBuilder().withUserId(userId.toString()).build();
		final BuildingQueueModel buildingQueueModel = BuildingQueueModel.newBuilder()
				.withBuildingId(1L)
				.withCityId(cityId.toString())
				.build();

		when(buildingQueueService.createBuildingQueue(any(BuildingQueue.class), eq(userId)))
				.thenReturn(createBuildingQueue());

		sut.create(buildingQueueModel, user);

		verify(buildingQueueService).createBuildingQueue(any(BuildingQueue.class), eq(userId));
	}

}
