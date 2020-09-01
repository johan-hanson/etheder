package se.webinfostudio.game.etheder.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class BuildingDataDAOTest {

	private BuildingDataDAO sut;

	@BeforeEach
	void before() {
		sut = new BuildingDataDAO();
	}

	void findById() {
		final BuildingData buildingData = createBuildingData();
		sut.persist(buildingData);
		final Optional<BuildingData> result = sut.findById(buildingData.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(buildingData.getId());
		assertThat(result.get().getName()).isEqualTo(buildingData.getName());
	}

	void persist() {
		final BuildingData buildingData = createBuildingData();
		final BuildingData result = sut.persist(buildingData);

		assertThat(result.getId()).isEqualTo(buildingData.getId());
		assertThat(result.getName()).isEqualTo(buildingData.getName());
	}
}
