package se.webinfostudio.game.etheder.dao.building;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createBuilding;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.building.Building;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class BuildingDAOTest {

	private BuildingDAO sut;
	private TestDAO testDAO;

	@BeforeEach
	public void before() {
		sut = new BuildingDAO();
		testDAO = new TestDAO();
	}

	void create() {
		final Building building = createBuilding();
		final UUID id = sut.create(building);

		assertThat(id).isEqualTo(building.getId());
	}

	void findAll() {
		final Building building1 = createBuilding();
		final Building building2 = createBuilding(randomUUID(), "Stable");
		final List<Building> result = sut.findAll();

		assertThat(result).hasSize(2);
	}

	void findById() {
		final Building building = createBuilding();
		final UUID id = sut.create(building);

		assertThat(id).isEqualTo(building.getId());
	}
}
