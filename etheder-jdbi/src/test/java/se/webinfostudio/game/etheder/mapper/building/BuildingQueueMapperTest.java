package se.webinfostudio.game.etheder.mapper.building;

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

import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

public class BuildingQueueMapperTest {

	private BuildingQueueMapper sut;

	@Mock
	private ResultSet rs;

	@Mock
	private StatementContext ctx;

	@BeforeEach
	protected void setUp() throws Exception {
		sut = new BuildingQueueMapper();
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
		when(rs.getInt("ticks")).thenReturn(10);
		when(rs.getLong("building_id")).thenReturn(500L);
		when(rs.getObject("cityid", UUID.class)).thenReturn(id);

		final BuildingQueue result = sut.map(rs, ctx);

		assertThat(result.getId()).isEqualTo(id);
		assertThat(result.getTicks()).isEqualTo(10);
		assertThat(result.getCityId()).isEqualTo(id);
		assertThat(result.getBuildingId()).isEqualTo(500L);
	}
}
