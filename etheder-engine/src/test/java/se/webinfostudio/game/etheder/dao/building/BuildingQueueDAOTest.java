package se.webinfostudio.game.etheder.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

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

	private BuildingQueueDAO sut;
	private TestDAO testDAO;

	@BeforeEach
	void before() {
		sut = new BuildingQueueDAO();
		testDAO = new TestDAO();
	}

	void persist() {
		final BuildingQueue buildingQueue = createBuildingQueue();
		buildingQueue.setBuilding((BuildingData) testDAO.persist(buildingQueue.getBuilding()));
		final BuildingQueue result = sut.persist(buildingQueue);

		assertThat(result.getId()).isEqualTo(buildingQueue.getId());
	}

}
