package se.webinfostudio.game.etheder.engine.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class BuildingDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(Building.class)
			.addEntityClass(BuildingData.class).build();

	private BuildingDAO sut;
	private TestDAO testDAO;

	@Before
	public void before() {
		sut = new BuildingDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	public void createBuilding() {
		final BuildingData buildingData = createBuildingData();
		final Building result = sut.createBuilding((BuildingData) testDAO.persist(buildingData));

		assertThat(result).isNotNull();
		assertThat(result.getBuildingData().getId()).isEqualTo(buildingData.getId());
	}
}
