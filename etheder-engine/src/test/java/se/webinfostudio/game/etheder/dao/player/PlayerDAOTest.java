package se.webinfostudio.game.etheder.dao.player;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class PlayerDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(Player.class)
			.addEntityClass(City.class)
			.addEntityClass(Building.class)
			.addEntityClass(BuildingData.class)
			.build();

	private PlayerDAO sut;

	@BeforeEach
	void before() {
		sut = new PlayerDAO(database.getSessionFactory());
	}

	@Test
	void persist() {
		final Player player = createPlayer();
		final Player result = sut.persist(player);

		assertThat(result.getId()).isEqualTo(player.getId());
	}

}
