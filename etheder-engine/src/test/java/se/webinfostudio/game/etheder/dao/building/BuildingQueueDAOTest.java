package se.webinfostudio.game.etheder.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class BuildingQueueDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(BuildingQueue.class)
			.addEntityClass(BuildingData.class).build();

	private BuildingQueueDAO sut;
	private TestDAO testDAO;

	@Before
	public void before() {
		sut = new BuildingQueueDAO(database.getSessionFactory());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	public void persist() {
		final BuildingQueue buildingQueue = createBuildingQueue();
		buildingQueue.setBuilding((BuildingData) testDAO.persist(buildingQueue.getBuilding()));
		final BuildingQueue result = sut.persist(buildingQueue);

		assertThat(result.getId()).isEqualTo(buildingQueue.getId());
	}

}
