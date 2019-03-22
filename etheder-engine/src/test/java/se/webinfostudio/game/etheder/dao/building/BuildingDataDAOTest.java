package se.webinfostudio.game.etheder.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class BuildingDataDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(BuildingData.class).build();

	private BuildingDataDAO sut;

	@BeforeEach
	void before() {
		sut = new BuildingDataDAO(database.getSessionFactory());
	}

	@Test
	void findById() {
		final BuildingData buildingData = createBuildingData();
		sut.persist(buildingData);
		final BuildingData result = sut.findById(buildingData.getId());

		assertThat(result.getId()).isEqualTo(buildingData.getId());
		assertThat(result.getName()).isEqualTo(buildingData.getName());
	}

	@Test
	void persist() {
		final BuildingData buildingData = createBuildingData();
		final BuildingData result = sut.persist(buildingData);

		assertThat(result.getId()).isEqualTo(buildingData.getId());
		assertThat(result.getName()).isEqualTo(buildingData.getName());
	}
}
