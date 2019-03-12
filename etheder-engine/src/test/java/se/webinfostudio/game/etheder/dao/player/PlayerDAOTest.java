package se.webinfostudio.game.etheder.dao.player;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class PlayerDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(Player.class)
			.addEntityClass(City.class)
			.addEntityClass(Building.class)
			.addEntityClass(BuildingData.class)
			.build();

	private PlayerDAO sut;

	@Before
	public void before() {
		sut = new PlayerDAO(database.getSessionFactory());
	}

	@Test
	public void persist() {
		final Player player = createPlayer();
		final Player result = sut.persist(player);

		assertThat(result.getId()).isEqualTo(player.getId());
	}

}
