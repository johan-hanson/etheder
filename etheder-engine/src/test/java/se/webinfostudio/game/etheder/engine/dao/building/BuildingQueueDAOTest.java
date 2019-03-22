package se.webinfostudio.game.etheder.engine.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class BuildingQueueDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(BuildingQueue.class)
			.addEntityClass(BuildingData.class).build();

	private BuildingQueueDAO sut;
	private TestDAO testDAO;

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

	@BeforeEach
	void before() {
		sut = new BuildingQueueDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	void decreaseTicks() {
		final BuildingQueue buildingQueue = createBuildingQueue();
		final BuildingData buildingData = createBuildingData();
		buildingQueue.setBuilding((BuildingData) testDAO.persist(buildingData));
		testDAO.persist(buildingQueue);
		final int result = database.inTransaction(() -> {
			return sut.decreaseTicks();
		});

		assertThat(result).isEqualTo(1);
	}

}
