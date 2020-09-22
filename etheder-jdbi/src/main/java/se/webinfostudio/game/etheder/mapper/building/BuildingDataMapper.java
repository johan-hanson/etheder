package se.webinfostudio.game.etheder.mapper.building;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.core.UnitType;

public class BuildingDataMapper implements RowMapper<BuildingData> {

	@Override
	public BuildingData map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final BuildingData buildingData = new BuildingData();
		buildingData.setCostFood(rs.getLong("costfood"));
		buildingData.setCostGold(rs.getLong("costgold"));
		buildingData.setCostIron(rs.getLong("costiron"));
		buildingData.setCostStone(rs.getLong("coststone"));
		buildingData.setCostWood(rs.getLong("costwood"));
		buildingData.setDescription(rs.getString("description"));
		buildingData.setId(rs.getLong("id"));
		buildingData.setMaxNumber(rs.getInt("maxnumber"));
		buildingData.setName(rs.getString("name"));
		buildingData.setPopulationCapacity(rs.getInt("populationcapacity"));
		buildingData.setTicks(rs.getInt("ticks"));
		buildingData.setUnitType(UnitType.valueOf(rs.getString("unittype")));
		return buildingData;
	}

}
