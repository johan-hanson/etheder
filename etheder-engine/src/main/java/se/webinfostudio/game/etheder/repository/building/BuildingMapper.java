package se.webinfostudio.game.etheder.repository.building;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.building.Building;

public class BuildingMapper implements RowMapper<Building> {

	@Override
	public Building map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
