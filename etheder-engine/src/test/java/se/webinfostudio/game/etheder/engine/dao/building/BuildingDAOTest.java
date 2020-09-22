package se.webinfostudio.game.etheder.engine.dao.building;

import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuildingData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class BuildingDAOTest {

	private BuildingDAO sut;

	@BeforeEach
	void before() {
		sut = new BuildingDAO();
	}

	@Test
	void createBuilding() {
		final BuildingData buildingData = createBuildingData();
//		final Building result = sut.createBuilding((BuildingData) testDAO.persist(buildingData));

//		assertThat(result).isNotNull();
//		assertThat(result.getBuildingData().getId()).isEqualTo(buildingData.getId());
	}
}
