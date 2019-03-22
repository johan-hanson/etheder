package se.webinfostudio.game.etheder.engine.dao.building;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class BuildingDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(Building.class)
			.addEntityClass(BuildingData.class).build();

	private BuildingDAO sut;
	private TestDAO testDAO;

	@BeforeEach
	void before() {
		sut = new BuildingDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	void createBuilding() {
		final BuildingData buildingData = createBuildingData();
		final Building result = sut.createBuilding((BuildingData) testDAO.persist(buildingData));

		assertThat(result).isNotNull();
		assertThat(result.getBuildingData().getId()).isEqualTo(buildingData.getId());
	}
}
