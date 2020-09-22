package se.webinfostudio.game.etheder.repository.utils;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ResultSetUtilsTest {

	@Mock
	private ResultSet rs;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
	}

	@Test
	void getUUID() throws SQLException {
		final UUID id = randomUUID();
		when(rs.getObject("id", UUID.class)).thenReturn(id);

		final UUID result = ResultSetUtils.getUUID(rs, "id");

		assertThat(result).isEqualTo(id);
	}

	@Nested
	class getTimestamp {

		@Test
		void notNull() throws SQLException {
			final Timestamp timestamp = new Timestamp(1000L);
			when(rs.getTimestamp("timestamp")).thenReturn(timestamp);

			final LocalDateTime result = ResultSetUtils.getTimestamp(rs, "timestamp");

			assertThat(result).isEqualTo(timestamp.toLocalDateTime());
		}

		@Test
		void isNull() throws SQLException {

			final LocalDateTime result = ResultSetUtils.getTimestamp(rs, "timestamp");

			assertThat(result).isNull();
		}

	}
}
