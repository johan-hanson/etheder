package se.webinfostudio.game.etheder.entity.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.webinfostudio.game.etheder.entity.converters.UnitTypeConverter;

/**
 *
 * @author Johan Hanson
 */
public class UnitTypeConverterTest {

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	public UnitTypeConverterTest() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of convertToDatabaseColumn method, of class UnitTypeConverter.
	 */
	@Test
	public void testConvertToDatabaseColumnArcher() {
		final UnitType attribute = UnitType.ARCHER;
		final UnitTypeConverter instance = new UnitTypeConverter();
		final String expResult = "A";
		final String result = instance.convertToDatabaseColumn(attribute);
		assertThat(result).isEqualTo(expResult);
	}

	/**
	 * Test of convertToDatabaseColumn method, of class UnitTypeConverter.
	 */
	@Test
	public void testConvertToDatabaseColumnCavalry() {
		final UnitType attribute = UnitType.CAVALRY;
		final UnitTypeConverter instance = new UnitTypeConverter();
		final String expResult = "C";
		final String result = instance.convertToDatabaseColumn(attribute);
		assertThat(result).isEqualTo(expResult);
	}

	/**
	 * Test of convertToDatabaseColumn method, of class UnitTypeConverter.
	 */
	@Test
	public void testConvertToDatabaseColumnInfantry() {
		final UnitType attribute = UnitType.INFANTRY;
		final UnitTypeConverter instance = new UnitTypeConverter();
		final String expResult = "I";
		final String result = instance.convertToDatabaseColumn(attribute);
		assertThat(result).isEqualTo(expResult);
	}

	/**
	 * Test of convertToEntityAttribute method, of class UnitTypeConverter.
	 */
	@Test
	public void testConvertToEntityAttribute() {
		final String dbData = "S";
		final UnitTypeConverter instance = new UnitTypeConverter();
		final UnitType expResult = UnitType.SIEGE;
		final UnitType result = instance.convertToEntityAttribute(dbData);
		assertThat(result).isEqualTo(expResult);
	}

	/**
	 * Test of convertToDatabaseColumn method, of class UnitTypeConverter.
	 */
//    @Test
//    public void testConvertToDatabaseColumnNull() {
//        UnitType attribute = null;
//        UnitTypeConverter instance = new UnitTypeConverter();
//        String result = instance.convertToDatabaseColumn(attribute);
//        Assert.assertNull(result);
//    }

	/**
	 * Test of convertToEntityAttribute method, of class UnitTypeConverter.
	 */
//    @Test
//    public void testConvertToEntityAttributeNull() {
//        String dbData = null;
//        UnitTypeConverter instance = new UnitTypeConverter();
//        UnitType result = instance.convertToEntityAttribute(dbData);
//        assertNull(result);
//    }

	/**
	 * If new enum is added this method will fail
	 */
//    @Test
//    public void testNewEnum() {
//        for (UnitType type : UnitType.values()) {
//            new UnitTypeConverter().convertToDatabaseColumn(type);
//        }
//    }
}
