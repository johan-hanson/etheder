package se.webinfostudio.game.etheder.entity.player;

import static java.lang.Boolean.TRUE;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.core.UnitType.INFANTRY;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

/**
 *
 * @author Johan Hanson
 */
public class ArmyTest {

	@Test
	public void testSetDefaultArmy() {
		final Boolean defaultArmy = TRUE;
		final Army instance = new Army();
		instance.setDefaultArmy(defaultArmy);
		assertThat(instance.getDefaultArmy()).isEqualTo(defaultArmy);
	}

	@Test
	public void testSetId() {
		final UUID id = UUID.randomUUID();
		final Army instance = new Army();
		instance.setId(id);
		assertThat(instance.getId()).isEqualTo(id);
	}

	@Test
	void addUnits() {
		final UnitQueue uq = new UnitQueue();
		uq.setCity(new CityRef(randomUUID()));

		final Army army = new Army();
		army.setNrOfInfantry(1000);
		army.addUnits(INFANTRY, 100);
		assertThat(army.getNrOfInfantry()).isEqualTo(Integer.valueOf(1100));
	}

	@Test
	void testSetName() {
		final String name = "My best army";
		final Army instance = new Army();
		instance.setName(name);
		assertThat(instance.getName()).isEqualTo(name);
	}

	@Test
	void testSetNrOfArcher() {
		final Integer nrOfArcher = 3000;
		final Army instance = new Army();
		instance.setNrOfArcher(nrOfArcher);
		assertThat(instance.getNrOfArcher()).isEqualTo(nrOfArcher);
	}

	@Test
	void testSetNrOfCatapult() {
		final Integer nrOfCatapult = 4000;
		final Army instance = new Army();
		instance.setNrOfSiege(nrOfCatapult);
		assertThat(instance.getNrOfSiege()).isEqualTo(nrOfCatapult);
	}

	@Test
	void testSetNrOfCavalry() {
		final Integer nrOfCavalry = 2000;
		final Army instance = new Army();
		instance.setNrOfCavalry(nrOfCavalry);
		assertThat(instance.getNrOfCavalry()).isEqualTo(nrOfCavalry);
	}

	@Test
	void testSetNrOfInfantry() {
		final Integer nrOfInfantry = 1000;
		final Army instance = new Army();
		instance.setNrOfInfantry(nrOfInfantry);
		assertThat(instance.getNrOfInfantry()).isEqualTo(nrOfInfantry);
	}

	/**
	 * Test of setPlayer method, of class Army.
	 */
	@Test
	void testSetPlayer() {
		final Player player = new Player();
		final Army instance = new Army();
		instance.setPlayer(player);
		assertThat(instance.getPlayer()).isEqualTo(player);
	}
}
