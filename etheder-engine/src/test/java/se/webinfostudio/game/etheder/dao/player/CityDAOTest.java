package se.webinfostudio.game.etheder.dao.player;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class CityDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(City.class)
			.addEntityClass(Building.class)
			.addEntityClass(BuildingData.class)
			.build();

	private CityDAO sut;

	@BeforeEach
	void before() {
		sut = new CityDAO(database.getSessionFactory());
	}

	@Test
	void persist() {
		final City city = createCity();
		final City result = sut.persist(city);

		assertThat(result.getId()).isEqualTo(city.getId());
	}

}
