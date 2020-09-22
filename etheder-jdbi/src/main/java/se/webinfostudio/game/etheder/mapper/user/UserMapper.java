package se.webinfostudio.game.etheder.mapper.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.user.User;
import se.webinfostudio.game.etheder.repository.utils.ResultSetUtils;

public class UserMapper implements RowMapper<User> {

	@Override
	public User map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final User user = new User();
		user.setId(ResultSetUtils.getUUID(rs, "id"));
		user.setAge(rs.getInt("age"));
		user.setCountry(rs.getString("country"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("firstname"));
		user.setLastName(rs.getString("lastname"));
		return user;
	}

}
