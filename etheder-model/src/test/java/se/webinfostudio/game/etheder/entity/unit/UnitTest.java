package se.webinfostudio.game.etheder.entity.unit;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Johan Hanson
 */
public class UnitTest {

	@Test
	void testDescription() {
		final String desc = "My nice unit";
		final Unit instance = createUnit();
		instance.getUnitData().setDescription(desc);
		assertThat(instance.getUnitData().getDescription()).isEqualTo(desc);
	}

	@Test
	void testSetArmour() {
		final Integer armour = 12;
		final Unit instance = new Unit();
		instance.setArmour(armour);
		assertThat(instance.getArmour()).isEqualTo(armour);
	}

	@Test
	void testSetAttack() {
		final Integer attack = 10;
		final Unit instance = new Unit();
		instance.setAttack(attack);
		assertThat(instance.getAttack()).isEqualTo(attack);
	}

	@Test
	void testSetCostFood() {
		final Long cost = 800L;
		final Unit instance = createUnit();
		instance.getUnitData().setCostFood(cost);
		assertThat(instance.getUnitData().getCostFood()).isEqualTo(cost);
	}

	@Test
	void testSetCostGold() {
		final Long cost = 1800L;
		final Unit instance = createUnit();
		instance.getUnitData().setCostGold(cost);
		assertThat(instance.getUnitData().getCostGold()).isEqualTo(cost);
	}

	@Test
	void testSetCostIron() {
		final Long cost = 1200L;
		final Unit instance = createUnit();
		instance.getUnitData().setCostIron(cost);
		assertThat(instance.getUnitData().getCostIron()).isEqualTo(cost);
	}

	@Test
	void testSetCostStone() {
		final Long cost = 1800L;
		final Unit instance = createUnit();
		instance.getUnitData().setCostStone(cost);
		assertThat(instance.getUnitData().getCostStone()).isEqualTo(cost);
	}

	@Test
	void testSetCostWood() {
		final Long cost = 1500L;
		final Unit instance = createUnit();
		instance.getUnitData().setCostWood(cost);
		assertThat(instance.getUnitData().getCostWood()).isEqualTo(cost);
	}

	@Test
	void testSetDefensive() {
		final Integer defensive = 14;
		final Unit instance = new Unit();
		instance.setDefensive(defensive);
		assertThat(instance.getDefensive()).isEqualTo(defensive);
	}

	@Test
	void testSetId() {
		final UUID id = UUID.randomUUID();
		final Unit instance = new Unit();
		instance.setId(id);
		assertThat(instance.getId()).isEqualTo(id);
	}

	@Test
	void testSetLevel() {
		final Integer level = 1;
		final Unit instance = createUnit();
		instance.getUnitData().setLevel(level);
		assertThat(instance.getUnitData().getLevel()).isEqualTo(level);
	}

	@Test
	void testSetName() {
		final String name = "Cavalry";
		final Unit instance = createUnit();
		instance.getUnitData().setName(name);
		assertThat(instance.getUnitData().getName()).isEqualTo(name);
	}

	@Test
	void testSetSpeed() {
		final Integer speed = 8;
		final Unit instance = new Unit();
		instance.setSpeed(speed);
		assertThat(instance.getSpeed()).isEqualTo(speed);
	}

	@Test
	void testTicks() {
		final Integer ticks = 12;
		final Unit instance = createUnit();
		instance.getUnitData().setTicks(ticks);
		assertThat(instance.getUnitData().getTicks()).isEqualTo(ticks);
	}

	@Test
	void testToString() {
		final UUID id = randomUUID();
		final Unit instance = new Unit();
		instance.setId(id);
		final String expected = "Unit: ";
		assertThat(instance.toString()).startsWith(expected);
	}

	private Unit createUnit() {
		final Unit unit = new Unit();
		unit.setUnitData(new UnitData());
		return unit;
	}

}
