package se.webinfostudio.game.etheder.api.transformer.building;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createBuildingQueueModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.building.BuildingQueueModel;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingQueueTransformer;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueTransformerTest {

	@InjectMocks
	private BuildingQueueTransformer sut;

	@Test
	void apply() {
		final BuildingQueueModel buildingQueueModel = createBuildingQueueModel();
		final BuildingQueue result = sut.apply(buildingQueueModel);

		assertThat(result.getCity().getId().toString()).isEqualTo(buildingQueueModel.getCityId());
		assertThat(result.getBuilding().getName()).isEqualTo(buildingQueueModel.getBuildingName());
		assertThat(result.getBuilding().getDescription()).isEqualTo(buildingQueueModel.getDescription());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}
}
