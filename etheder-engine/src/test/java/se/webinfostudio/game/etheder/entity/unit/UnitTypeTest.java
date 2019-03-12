package se.webinfostudio.game.etheder.entity.unit;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static se.webinfostudio.game.etheder.entity.unit.UnitType.CAVALRY;
import static se.webinfostudio.game.etheder.entity.unit.UnitType.INFANTRY;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Johan Hanson
 */
public class UnitTypeTest {

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	public UnitTypeTest() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of values method, of class UnitType.
	 */
//    @Test
//    public void testValues() {
//        UnitType expResult = UnitType.INFANTRY;
//        UnitType result = UnitType.values()[0];
//        assertEquals(expResult, result);
//    }

	/**
	 * Test of valueOf method, of class UnitType.
	 */
//    @Test
//    public void testValueOf() {
//        String name = "INFANTRY";
//        UnitType expResult = UnitType.INFANTRY;
//        UnitType result = UnitType.valueOf(name);
//        assertEquals(expResult, result);
//    }

	/**
	 * Test of valueOf method, of class UnitType.
	 */
//    public void testValueOfNull() {
//        String name = null;
//        UnitType result = UnitType.valueOf(name);
//        Assert.assertNull(result);
//    }

	/**
	 * Test of unitType, of enum UnitType.
	 */
	@Test
	public void testUnitType() {
		final UnitType inf = INFANTRY;
		assertThat(inf, not(CAVALRY));
	}
}
