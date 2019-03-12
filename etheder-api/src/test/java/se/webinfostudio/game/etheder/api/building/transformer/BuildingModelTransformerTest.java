package se.webinfostudio.game.etheder.api.building.transformer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuilding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.building.BuildingModel;
import se.webinfostudio.game.etheder.api.transformer.building.BuildingModelTransformer;
import se.webinfostudio.game.etheder.entity.building.Building;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingModelTransformerTest {

	@InjectMocks
	private BuildingModelTransformer sut;

	@Test
	void apply() {
		final Building building = createBuilding();
		final BuildingModel result = sut.apply(building);

		assertThat(result.getBuildingId()).isEqualTo(building.getId().toString());
		assertThat(result.getName()).isEqualTo(building.getBuildingData().getName());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}
}
