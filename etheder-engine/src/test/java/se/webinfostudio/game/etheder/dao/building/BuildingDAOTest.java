package se.webinfostudio.game.etheder.dao.building;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuilding;

import java.util.List;
import java.util.UUID;

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
	public void before() {
		sut = new BuildingDAO(database.getSessionFactory());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	void create() {
		final Building building = createBuilding();
		final UUID id = sut.create(building);

		assertThat(id).isEqualTo(building.getId());
	}

	@Test
	void findAll() {
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
	void findById() {
		final Building building = createBuilding();
		final UUID id = sut.create(building);

		assertThat(id).isEqualTo(building.getId());
	}
}
