package se.webinfostudio.game.etheder.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;

import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class BuildingDataManualDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(BuildingData.class).build();

	private BuildingDataManualDAO sut;

	@Before
	public void before() {
		sut = new BuildingDataManualDAO(database.getSessionFactory());
	}

	@Test
	public void findById() {
		final BuildingData buildingData = createBuildingData();
		sut.persist(buildingData);
		final Optional<BuildingData> result = sut.findById(buildingData.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(buildingData.getId());
		assertThat(result.get().getName()).isEqualTo(buildingData.getName());
	}

	@Test
	public void persist() {
		final BuildingData buildingData = createBuildingData();
		final BuildingData result = sut.persist(buildingData);

		assertThat(result.getId()).isEqualTo(buildingData.getId());
		assertThat(result.getName()).isEqualTo(buildingData.getName());
	}

}
