package se.webinfostudio.game.etheder.mapper.building;

import static se.webinfostudio.game.etheder.repository.utils.ResultSetUtils.getUUID;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

public class BuildingQueueMapper implements RowMapper<BuildingQueue> {

	@Override
	public BuildingQueue map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final BuildingQueue buildingQueue = new BuildingQueue();
		buildingQueue.setId(getUUID(rs, "id"));
		buildingQueue.setTicks(rs.getInt("ticks"));
		buildingQueue.setCityId(getUUID(rs, "cityid"));
		buildingQueue.setBuildingId(rs.getLong("building_id"));
		return buildingQueue;
	}

}
