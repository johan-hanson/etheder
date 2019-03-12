package se.webinfostudio.game.etheder.engine.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
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
		sut = new BuildingQueueDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	public void decreaseTicks() {
		final BuildingQueue buildingQueue = createBuildingQueue();
		final BuildingData buildingData = createBuildingData();
		buildingQueue.setBuilding((BuildingData) testDAO.persist(buildingData));
		testDAO.persist(buildingQueue);
		final int result = database.inTransaction(() -> {
			return sut.decreaseTicks();
		});

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void findAllFinished() {
		final BuildingQueue buildingQueue1 = createBuildingQueue();
		final BuildingQueue buildingQueue2 = createBuildingQueue();
		final BuildingData buildingData = createBuildingData();
		buildingQueue1.setBuilding((BuildingData) testDAO.persist(buildingData));
		buildingQueue2.setBuilding(buildingQueue1.getBuilding());
		buildingQueue2.setTicks(0);
		testDAO.persist(buildingQueue1);
		testDAO.persist(buildingQueue2);
		final List<BuildingQueue> result = database.inTransaction(() -> {
			return sut.findAllFinished();
		});

		assertThat(result).hasSize(1);
	}

}
