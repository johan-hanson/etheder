package se.webinfostudio.game.etheder.api.building.transformer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueModelTransformer;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueModelTransformerTest {

	@InjectMocks
	private BuildingQueueModelTransformer sut;

	@Test
	void apply() {
		final BuildingQueue buildingQueue = createBuildingQueue();
		final BuildingQueueModel result = sut.apply(buildingQueue);

		assertThat(result.getCityId()).isEqualTo(buildingQueue.getCity().getId().toString());
		assertThat(result.getBuildingId()).isEqualTo(buildingQueue.getBuilding().getId());
		assertThat(result.getBuildingName()).isEqualTo(buildingQueue.getBuilding().getName());
		assertThat(result.getBuildingQueueId()).isEqualTo(buildingQueue.getId().toString());
		assertThat(result.getDescription()).isEqualTo(buildingQueue.getBuilding().getDescription());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}
}
