package se.webinfostudio.game.etheder.dataimport;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.unit.UnitType;

/**
 *
 * @author Johan Hanson
 *
 */
public class ImportBuildingDataTest extends ImportDataTest {

	@InjectMocks
	private ImportBuildingData sut;

	@Test
	void getImports() throws DataImportException {
		final List<BuildingData> buildings = sut.getImports();

		assertThat(buildings).hasSize(2);
		assertThat(buildings.get(0).getName()).isEqualTo("Name");
		assertThat(buildings.get(0).getDescription()).isEqualTo("Description");
		assertThat(buildings.get(0).getUnitType()).isEqualTo(UnitType.INFANTRY);
	}

}
