package se.webinfostudio.game.etheder.mapper.user;

import static se.webinfostudio.game.etheder.repository.utils.ResultSetUtils.getTimestamp;
import static se.webinfostudio.game.etheder.repository.utils.ResultSetUtils.getUUID;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.user.Login;

public class LoginMapper implements RowMapper<Login> {

	@Override
	public Login map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final Login login = new Login();
		login.setId(getUUID(rs, "id"));
		login.setPasswordHash(rs.getString("passwordhash"));
		login.setToken(getUUID(rs, "token"));
		login.setTokenExpireDate(getTimestamp(rs, "tokenexpiredate"));
		login.setUserName(rs.getString("username"));
		return login;
	}

}
