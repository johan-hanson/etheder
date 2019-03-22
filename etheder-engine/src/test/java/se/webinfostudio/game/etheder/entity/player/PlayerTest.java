package se.webinfostudio.game.etheder.entity.player;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Johan Hanson
 */
public class PlayerTest {

	@Test
	void testPlayer() {
		final UUID id = randomUUID();
		final Player p = new Player();
		p.setId(id);
		p.setCountry("Sweden");

		final Long gold = 4000L;
		final Long food = 5000L;
		final Long wood = 6000L;
		final Long iron = 7000L;
		final Long stone = 8000L;
		p.setGold(gold);
		p.setFood(food);
		p.setWood(wood);
		p.setIron(iron);
		p.setStone(stone);

		assertThat(p.getId()).isEqualTo(id);
		assertThat(p.getCountry()).isEqualTo("Sweden");

		assertThat(p.getGold()).isEqualTo(gold);
		assertThat(p.getFood()).isEqualTo(food);
		assertThat(p.getWood()).isEqualTo(wood);
		assertThat(p.getIron()).isEqualTo(iron);
		assertThat(p.getStone()).isEqualTo(stone);
	}

}
