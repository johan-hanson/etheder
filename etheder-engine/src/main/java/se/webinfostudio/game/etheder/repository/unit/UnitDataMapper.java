package se.webinfostudio.game.etheder.repository.unit;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.core.UnitType;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

public class UnitDataMapper implements RowMapper<UnitData> {

	@Override
	public UnitData map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final UnitData unitData = new UnitData();
		unitData.setCostFood(rs.getLong("costfood"));
		unitData.setCostGold(rs.getLong("costgold"));
		unitData.setCostIron(rs.getLong("costiron"));
		unitData.setCostStone(rs.getLong("coststone"));
		unitData.setCostWood(rs.getLong("costwood"));
		unitData.setDescription(rs.getString("description"));
		unitData.setId(rs.getLong("id"));
		unitData.setHealth(rs.getInt("health"));
		unitData.setSpeed(rs.getInt("speed"));
		unitData.setArmour(rs.getInt("armour"));
		unitData.setAttack(rs.getInt("attack"));
		unitData.setDefensive(rs.getInt("defensive"));
		unitData.setName(rs.getString("name"));
		unitData.setLevel(rs.getInt("unitlevel"));
		unitData.setTicks(rs.getInt("ticks"));
		unitData.setUnitType(UnitType.valueOf(rs.getString("unittype")));
		return unitData;
	}

}
