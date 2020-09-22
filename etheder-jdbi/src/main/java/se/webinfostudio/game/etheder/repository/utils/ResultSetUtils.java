package se.webinfostudio.game.etheder.repository.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public final class ResultSetUtils {

	private ResultSetUtils() {
		// not used
	}

	public static UUID getUUID(final ResultSet rs, final String name) throws SQLException {
		return rs.getObject(name, UUID.class);
	}

	public static LocalDateTime getTimestamp(final ResultSet rs, final String name) throws SQLException {
		final Timestamp timestamp = rs.getTimestamp(name);
		return timestamp == null ? null : timestamp.toLocalDateTime();
	}
}
