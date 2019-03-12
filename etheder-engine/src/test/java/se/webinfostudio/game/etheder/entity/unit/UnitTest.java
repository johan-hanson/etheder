package se.webinfostudio.game.etheder.entity.unit;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Johan Hanson
 */
public class UnitTest {

	public UnitTest() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of setDescription method, of class Unit.
	 */
	@Test
	public void testDescription() {
		final String desc = "My nice unit";
		final Unit instance = createUnit();
		instance.getUnitData().setDescription(desc);
		assertThat(instance.getUnitData().getDescription()).isEqualTo(desc);
	}

	/**
	 * Test of setArmour method, of class Unit.
	 */
	@Test
	public void testSetArmour() {
		final Integer armour = 12;
		final Unit instance = new Unit();
		instance.setArmour(armour);
		assertThat(instance.getArmour()).isEqualTo(armour);
	}

	/**
	 * Test of setAttack method, of class Unit.
	 */
	@Test
	public void testSetAttack() {
		final Integer attack = 10;
		final Unit instance = new Unit();
		instance.setAttack(attack);
		assertThat(instance.getAttack()).isEqualTo(attack);
	}

	/**
	 * Test of setCostFood method, of class Unit.
	 */
	@Test
	public void testSetCostFood() {
		final Integer cost = 800;
		final Unit instance = createUnit();
		instance.getUnitData().setCostFood(cost);
		assertThat(instance.getUnitData().getCostFood()).isEqualTo(cost);
	}

	/**
	 * Test of setCostGold method, of class Unit.
	 */
	@Test
	public void testSetCostGold() {
		final Integer cost = 1800;
		final Unit instance = createUnit();
		instance.getUnitData().setCostGold(cost);
		assertThat(instance.getUnitData().getCostGold()).isEqualTo(cost);
	}

	/**
	 * Test of setCostIron method, of class Unit.
	 */
	@Test
	public void testSetCostIron() {
		final Integer cost = 1200;
		final Unit instance = createUnit();
		instance.getUnitData().setCostIron(cost);
		assertThat(instance.getUnitData().getCostIron()).isEqualTo(cost);
	}

	/**
	 * Test of setCostStone method, of class Unit.
	 */
	@Test
	public void testSetCostStone() {
		final Integer cost = 1800;
		final Unit instance = createUnit();
		instance.getUnitData().setCostStone(cost);
		assertThat(instance.getUnitData().getCostStone()).isEqualTo(cost);
	}

	/**
	 * Test of setCostWood method, of class Unit.
	 */
	@Test
	public void testSetCostWood() {
		final Integer cost = 1500;
		final Unit instance = createUnit();
		instance.getUnitData().setCostWood(cost);
		assertThat(instance.getUnitData().getCostWood()).isEqualTo(cost);
	}

	/**
	 * Test of setDefensive method, of class Unit.
	 */
	@Test
	public void testSetDefensive() {
		final Integer defensive = 14;
		final Unit instance = new Unit();
		instance.setDefensive(defensive);
		assertThat(instance.getDefensive()).isEqualTo(defensive);
	}

	/**
	 * Test of setId method, of class Unit.
	 */
	@Test
	public void testSetId() {
		final UUID id = UUID.randomUUID();
		final Unit instance = new Unit();
		instance.setId(id);
		assertThat(instance.getId()).isEqualTo(id);
	}

	/**
	 * Test of setLevel method, of class Unit.
	 */
	@Test
	public void testSetLevel() {
		final Integer level = 1;
		final Unit instance = createUnit();
		instance.getUnitData().setLevel(level);
		assertThat(instance.getUnitData().getLevel()).isEqualTo(level);
	}

	/**
	 * Test of setName method, of class Unit.
	 */
	@Test
	public void testSetName() {
		final String name = "Cavalry";
		final Unit instance = createUnit();
		instance.getUnitData().setName(name);
		assertThat(instance.getUnitData().getName()).isEqualTo(name);
	}

	/**
	 * Test of setSpeed method, of class Unit.
	 */
	@Test
	public void testSetSpeed() {
		final Integer speed = 8;
		final Unit instance = new Unit();
		instance.setSpeed(speed);
		assertThat(instance.getSpeed()).isEqualTo(speed);
	}

	/**
	 * Test of setTicks method, of class Unit.
	 */
	@Test
	public void testTicks() {
		final Integer ticks = 12;
		final Unit instance = createUnit();
		instance.getUnitData().setTicks(ticks);
		assertThat(instance.getUnitData().getTicks()).isEqualTo(ticks);
	}

	/**
	 * Test of setAttack method, of class Unit.
	 */
	@Test
	public void testToString() {
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
