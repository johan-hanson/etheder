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

import se.webinfostudio.game.etheder.entity.player.Player;

public class PlayerMapperTest {

	private PlayerMapper sut;

	@Mock
	private ResultSet rs;

	@Mock
	private StatementContext ctx;

	@BeforeEach
	protected void setUp() throws Exception {
		sut = new PlayerMapper();
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
		when(rs.getString("country")).thenReturn("England");
		when(rs.getString("name")).thenReturn("Edward");
		when(rs.getInt("archerTechLevel")).thenReturn(1);
		when(rs.getInt("cavalryTechLevel")).thenReturn(1);
		when(rs.getInt("infantryTechLevel")).thenReturn(1);
		when(rs.getInt("siegeTechLevel")).thenReturn(1);
		when(rs.getLong("food")).thenReturn(100L);
		when(rs.getLong("wood")).thenReturn(200L);
		when(rs.getLong("gold")).thenReturn(300L);
		when(rs.getLong("iron")).thenReturn(400L);
		when(rs.getLong("stone")).thenReturn(500L);
		when(rs.getObject("userid", UUID.class)).thenReturn(id);

		final Player result = sut.map(rs, ctx);

		assertThat(result.getId()).isEqualTo(id);
		assertThat(result.getName()).isEqualTo("Edward");
		assertThat(result.getCountry()).isEqualTo("England");
		assertThat(result.getArcherTechLevel()).isEqualTo(1);
		assertThat(result.getCavalryTechLevel()).isEqualTo(1);
		assertThat(result.getInfantryTechLevel()).isEqualTo(1);
		assertThat(result.getSiegeTechLevel()).isEqualTo(1);
		assertThat(result.getFood()).isEqualTo(100L);
		assertThat(result.getWood()).isEqualTo(200L);
		assertThat(result.getStone()).isEqualTo(500L);
		assertThat(result.getGold()).isEqualTo(300L);
		assertThat(result.getIron()).isEqualTo(400L);
		assertThat(result.getUserId()).isEqualTo(id);
	}
}
