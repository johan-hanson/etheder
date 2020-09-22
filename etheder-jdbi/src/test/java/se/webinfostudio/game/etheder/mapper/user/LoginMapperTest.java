package se.webinfostudio.game.etheder.mapper.user;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

import org.jdbi.v3.core.statement.StatementContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.user.Login;

public class LoginMapperTest {

	private LoginMapper sut;

	@Mock
	private ResultSet rs;

	@Mock
	private StatementContext ctx;

	@BeforeEach
	protected void setUp() throws Exception {
		sut = new LoginMapper();
		initMocks(this);
	}

	@AfterEach
	void after() {
		verifyZeroInteractions(ctx);
	}

	@Test
	void map() throws SQLException {
		final UUID id = randomUUID();
		final UUID token = randomUUID();
		final Timestamp timestamp = new Timestamp(1000L);
		when(rs.getObject("id", UUID.class)).thenReturn(id);
		when(rs.getString("passwordhash")).thenReturn("qwerty1234");
		when(rs.getObject("token", UUID.class)).thenReturn(token);
		when(rs.getTimestamp("tokenexpiredate")).thenReturn(timestamp);
		when(rs.getString("username")).thenReturn("hanjo");

		final Login result = sut.map(rs, ctx);

		assertThat(result.getId()).isEqualTo(id);
		assertThat(result.getUserName()).isEqualTo("hanjo");
		assertThat(result.getToken()).isEqualTo(token);
		assertThat(result.getPasswordHash()).isEqualTo("qwerty1234");
		assertThat(result.getTokenExpireDate()).isEqualTo(timestamp.toLocalDateTime());
	}

}
