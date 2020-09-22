package se.webinfostudio.game.etheder.mapper.player;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.jdbi.v3.core.statement.StatementContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityLevel;

public class CityMapperTest {

	private CityMapper sut;

	@Mock
	private ResultSet rs;

	@Mock
	private StatementContext ctx;

	@BeforeEach
	protected void setUp() throws Exception {
		sut = new CityMapper();
		initMocks(this);
	}

	@AfterEach
	void after() {
		verifyZeroInteractions(ctx);
	}

	@Test
	void map() throws SQLException {
		final UUID id = randomUUID();
		when(rs.getObject("id", UUID.class)).thenReturn(id);
		when(rs.getString("name")).thenReturn("Paris");
		when(rs.getInt("acres")).thenReturn(200);
		when(rs.getInt("citylevel")).thenReturn(4);
		when(rs.getInt("farmers")).thenReturn(5);
		when(rs.getInt("ironminers")).thenReturn(6);
		when(rs.getInt("lumberjacks")).thenReturn(7);
		when(rs.getInt("merchants")).thenReturn(8);
		when(rs.getLong("population")).thenReturn(10L);
		when(rs.getInt("stonemasons")).thenReturn(9);
		when(rs.getObject("playerid", UUID.class)).thenReturn(id);

		final City result = sut.map(rs, ctx);

		assertThat(result.getId()).isEqualTo(id);
		assertThat(result.getName()).isEqualTo("Paris");
		assertThat(result.getAcres()).isEqualTo(200);
		assertThat(result.getCityLevel()).isEqualTo(CityLevel.LEVEL4);
		assertThat(result.getFarmers()).isEqualTo(5);
		assertThat(result.getIronminers()).isEqualTo(6);
		assertThat(result.getLumberjacks()).isEqualTo(7);
		assertThat(result.getMerchants()).isEqualTo(8);
		assertThat(result.getPopulation()).isEqualTo(10L);
		assertThat(result.getStonemasons()).isEqualTo(9);
		assertThat(result.getPlayerId()).isEqualTo(id);
	}
}
