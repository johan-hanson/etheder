package se.webinfostudio.game.etheder.api.transformer.building;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createBuildingModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.building.BuildingModel;
import se.webinfostudio.game.etheder.entity.building.Building;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingTransformerTest {

	@InjectMocks
	private BuildingTransformer sut;

	@Test
	void apply() {
		final BuildingModel buildingModel = createBuildingModel();
		final Building result = sut.apply(buildingModel);

//		assertThat(result.getBuildingData().getName()).isEqualTo(buildingModel.getName());
		assertThat(result.getId().toString()).isEqualTo(buildingModel.getBuildingId());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}
}
