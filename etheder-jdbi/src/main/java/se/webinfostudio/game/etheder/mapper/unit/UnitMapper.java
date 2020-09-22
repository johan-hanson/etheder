package se.webinfostudio.game.etheder.mapper.unit;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.unit.Unit;

public class UnitMapper implements RowMapper<Unit> {

	@Override
	public Unit map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
