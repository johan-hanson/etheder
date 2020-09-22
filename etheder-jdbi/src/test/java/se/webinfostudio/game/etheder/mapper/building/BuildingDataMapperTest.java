package se.webinfostudio.game.etheder.mapper.building;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.core.UnitType;

public class BuildingDataMapperTest {

	private BuildingDataMapper sut;

	@Mock
	private ResultSet rs;

	@Mock
	private StatementContext ctx;

	@BeforeEach
	protected void setUp() throws Exception {
		sut = new BuildingDataMapper();
		initMocks(this);
	}

	@AfterEach
	void after() {
		verifyZeroInteractions(ctx);
	}

	@Test
	void map() throws SQLException {
		when(rs.getLong("id")).thenReturn(1L);
		when(rs.getString("description")).thenReturn("Can create infantry");
		when(rs.getString("name")).thenReturn("Barrack");
		when(rs.getInt("maxnumber")).thenReturn(5);
		when(rs.getInt("populationcapacity")).thenReturn(100);
		when(rs.getInt("ticks")).thenReturn(10);
		when(rs.getString("unittype")).thenReturn("INFANTRY");
		when(rs.getLong("costfood")).thenReturn(100L);
		when(rs.getLong("costgold")).thenReturn(200L);
		when(rs.getLong("costiron")).thenReturn(300L);
		when(rs.getLong("coststone")).thenReturn(400L);
		when(rs.getLong("costwood")).thenReturn(500L);

		final BuildingData result = sut.map(rs, ctx);

		assertThat(result.getId()).isEqualTo(1L);
		assertThat(result.getName()).isEqualTo("Barrack");
		assertThat(result.getDescription()).isEqualTo("Can create infantry");
		assertThat(result.getMaxNumber()).isEqualTo(5);
		assertThat(result.getPopulationCapacity()).isEqualTo(100);
		assertThat(result.getTicks()).isEqualTo(10);
		assertThat(result.getUnitType()).isEqualTo(UnitType.INFANTRY);
		assertThat(result.getCostFood()).isEqualTo(100L);
		assertThat(result.getCostGold()).isEqualTo(200L);
		assertThat(result.getCostIron()).isEqualTo(300L);
		assertThat(result.getCostStone()).isEqualTo(400L);
		assertThat(result.getCostWood()).isEqualTo(500L);
	}

}
