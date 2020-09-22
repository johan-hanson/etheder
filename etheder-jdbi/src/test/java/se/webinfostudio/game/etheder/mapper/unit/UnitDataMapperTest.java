package se.webinfostudio.game.etheder.mapper.unit;

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

import se.webinfostudio.game.etheder.entity.core.UnitType;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

public class UnitDataMapperTest {

	private UnitDataMapper sut;

	@Mock
	private ResultSet rs;

	@Mock
	private StatementContext ctx;

	@BeforeEach
	protected void setUp() throws Exception {
		sut = new UnitDataMapper();
		initMocks(this);
	}

	@AfterEach
	void after() {
		verifyZeroInteractions(ctx);
	}

	@Test
	void map() throws SQLException {
		when(rs.getLong("id")).thenReturn(1L);
		when(rs.getString("description")).thenReturn("Small knight");
		when(rs.getString("name")).thenReturn("Infantry");
		when(rs.getInt("unitlevel")).thenReturn(2);
		when(rs.getInt("health")).thenReturn(10);
		when(rs.getInt("speed")).thenReturn(3);
		when(rs.getInt("armour")).thenReturn(4);
		when(rs.getInt("attack")).thenReturn(5);
		when(rs.getInt("defensive")).thenReturn(6);
		when(rs.getInt("ticks")).thenReturn(10);
		when(rs.getString("unittype")).thenReturn("INFANTRY");
		when(rs.getLong("costfood")).thenReturn(100L);
		when(rs.getLong("costgold")).thenReturn(200L);
		when(rs.getLong("costiron")).thenReturn(300L);
		when(rs.getLong("coststone")).thenReturn(400L);
		when(rs.getLong("costwood")).thenReturn(500L);

		final UnitData result = sut.map(rs, ctx);

		assertThat(result.getId()).isEqualTo(1L);
		assertThat(result.getName()).isEqualTo("Infantry");
		assertThat(result.getDescription()).isEqualTo("Small knight");
		assertThat(result.getLevel()).isEqualTo(2);
		assertThat(result.getHealth()).isEqualTo(10);
		assertThat(result.getSpeed()).isEqualTo(3);
		assertThat(result.getArmour()).isEqualTo(4);
		assertThat(result.getAttack()).isEqualTo(5);
		assertThat(result.getDefensive()).isEqualTo(6);
		assertThat(result.getTicks()).isEqualTo(10);
		assertThat(result.getUnitType()).isEqualTo(UnitType.INFANTRY);
		assertThat(result.getCostFood()).isEqualTo(100L);
		assertThat(result.getCostGold()).isEqualTo(200L);
		assertThat(result.getCostIron()).isEqualTo(300L);
		assertThat(result.getCostStone()).isEqualTo(400L);
		assertThat(result.getCostWood()).isEqualTo(500L);
	}

}
