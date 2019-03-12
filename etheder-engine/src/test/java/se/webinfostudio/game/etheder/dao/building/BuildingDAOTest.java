package se.webinfostudio.game.etheder.dao.building;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuilding;

import java.util.List;
import java.util.UUID;

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
		sut = new BuildingDAO(database.getSessionFactory());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	public void create() {
		final Building building = createBuilding();
		final UUID id = sut.create(building);

		assertThat(id).isEqualTo(building.getId());
	}

	@Test
	public void findAll() {
		final Building building1 = createBuilding();
		final Building building2 = createBuilding(randomUUID(), "Stable");
		final List<Building> result = database.inTransaction(() -> {
			final BuildingData buildingData = (BuildingData) testDAO.persist(building1.getBuildingData());
			building1.setBuildingData(buildingData);
			building2.setBuildingData(buildingData);
			sut.create(building1);
			sut.create(building2);
			return sut.findAll();
		});

		assertThat(result).hasSize(2);
	}

	@Test
	public void findById() {
		final Building building = createBuilding();
		final UUID id = sut.create(building);

		assertThat(id).isEqualTo(building.getId());
	}
}
