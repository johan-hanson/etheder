package se.webinfostudio.game.etheder.dao.player;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.player.City;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class CityDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(City.class)
			.addEntityClass(Building.class)
			.addEntityClass(BuildingData.class)
			.build();

	private CityDAO sut;

	@Before
	public void before() {
		sut = new CityDAO(database.getSessionFactory());
	}

	@Test
	public void persist() {
		final City city = createCity();
		final City result = sut.persist(city);

		assertThat(result.getId()).isEqualTo(city.getId());
	}

}
