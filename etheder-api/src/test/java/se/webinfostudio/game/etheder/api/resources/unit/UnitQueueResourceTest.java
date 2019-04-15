package se.webinfostudio.game.etheder.api.resources.unit;

import static java.util.UUID.randomUUID;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.unit.UnitQueueModel;
import se.webinfostudio.game.etheder.api.transformer.unit.UnitQueueModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.unit.UnitQueueTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;
import se.webinfostudio.game.etheder.service.unit.UnitQueueService;

public class UnitQueueResourceTest {

	private UnitQueueResource sut;

	@Mock
	private ObjectMapper objectMapper;
	@Mock
	private UnitQueueService unitQueueService;

	private UnitQueueTransformer unitQueueTransformer;
	private UnitQueueModelTransformer unitQueueModelTransformer;

	@BeforeEach
	protected void setUp() throws Exception {
		initMocks(this);
		unitQueueModelTransformer = new UnitQueueModelTransformer();
		unitQueueTransformer = new UnitQueueTransformer();
		sut = new UnitQueueResource(objectMapper, unitQueueService, unitQueueTransformer, unitQueueModelTransformer);
	}

	@Test
	void create() {
		final UUID cityId = randomUUID();
		final UUID userId = randomUUID();
		final AuthUser user = AuthUser.newBuilder().withUserId(userId.toString()).build();
		final UnitQueueModel unitQueueModel = UnitQueueModel.newBuilder()
				.withCityId(cityId.toString())
				.withNumberOf(10)
				.withUnitId(1L)
				.build();
		final UnitQueue unitQueue = unitQueueTransformer.apply(unitQueueModel);
		unitQueue.setId(randomUUID());

		when(unitQueueService.createUnitQueue(any(UnitQueue.class), eq(userId))).thenReturn(unitQueue);

		sut.create(unitQueueModel, user);

		verify(unitQueueService).createUnitQueue(any(UnitQueue.class), eq(userId));
	}

	@Test
	void listQueues() {

	}
}
