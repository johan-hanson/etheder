package se.webinfostudio.game.etheder.api.resources.building;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuilding;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;

import java.util.Optional;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import se.webinfostudio.game.etheder.api.transformer.building.BuildingModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueModelTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.service.building.BuildingService;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingResourceTest {

	@InjectMocks
	private BuildingResource sut;

	@Mock
	private BuildingService buildingService;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		final BuildingModelTransformer buildingModelTransformer = new BuildingModelTransformer();
		final BuildingQueueModelTransformer buildingQueueModelTransformer = new BuildingQueueModelTransformer();

		sut = new BuildingResource(objectMapper,
				buildingService,
				buildingModelTransformer,
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

		when(buildingService.createBuilding(1L, cityId, userId)).thenReturn(createBuildingQueue());

		sut.create(1L, cityId.toString(), user);

		verify(buildingService).createBuilding(1L, cityId, userId);
	}

	@Test
	void getBuilding() {
		final UUID id = randomUUID();
		final Building building = createBuilding(id, "Barrack");
		when(buildingService.findById(id.toString())).thenReturn(Optional.of(building));

		final Response response = sut.getBuilding(id.toString());

		assertThat(response.getStatus()).isEqualTo(200);
	}

	@Test
	void getBuilding_shouldReturn404_whenBuildingNotFound() {
		final UUID id = randomUUID();
		when(buildingService.findById(id.toString())).thenReturn(Optional.empty());

		final Response response = sut.getBuilding(id.toString());

		assertThat(response.getStatus()).isEqualTo(404);
	}

	@Test
	void listAll() {
		when(buildingService.findAll()).thenReturn(asList(createBuilding(), createBuilding()));
		final Response response = sut.listAll();

		assertThat(response).isNotNull();
		assertThat(response.getStatus()).isEqualTo(200);
	}

}
