package se.webinfostudio.game.etheder.api.resources.building;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createBuildingQueueModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.api.resources.building.BuildingQueueResource;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueTransformer;
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
	}

	@Test
	void create() {
		final BuildingQueueModel buildingQueueModel = createBuildingQueueModel();
		final BuildingQueue buildingQueue = createBuildingQueue();

		when(buildingQueueService.createBuildingQueue(any(BuildingQueue.class))).thenReturn(buildingQueue);

		sut.create(buildingQueueModel);

		verify(buildingQueueService).createBuildingQueue(any(BuildingQueue.class));
	}
}
