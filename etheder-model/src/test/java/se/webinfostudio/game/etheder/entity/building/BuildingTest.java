package se.webinfostudio.game.etheder.entity.building;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Johan Hanson
 */
public class BuildingTest {

	@Test
	void testBuilding() {
		final Building b = new Building();
		b.setId(UUID.randomUUID());
		b.setBuildingDataId(1L);

		assertThat(b.getId()).isNotNull();
		assertThat(b.getBuildingDataId()).isEqualTo(1L);
		assertThat(b.toString()).startsWith("Building: ");
	}

}
