package se.webinfostudio.game.etheder.dao.building;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class BuildingManualDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(Building.class)
			.addEntityClass(BuildingData.class).build();

	private BuildingDAO sut;

	@BeforeEach
	void before() {
		sut = new BuildingDAO();
	}

}
