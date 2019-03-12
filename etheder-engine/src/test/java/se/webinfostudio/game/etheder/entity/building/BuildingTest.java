package se.webinfostudio.game.etheder.entity.building;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Johan Hanson
 */
public class BuildingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBuilding() {
		final Building b = new Building();
		b.setId(UUID.randomUUID());
		b.setBuildingData(new BuildingData());
		b.getBuildingData().setName("Stable");
		b.getBuildingData().setDescription("test test");

		assertThat(b.getId()).isNotNull();
		assertThat(b.getBuildingData().getName()).isEqualTo("Stable");
		assertThat(b.getBuildingData().getDescription()).isEqualTo("test test");
		assertThat(b.toString()).startsWith("Building: ");
	}

}
