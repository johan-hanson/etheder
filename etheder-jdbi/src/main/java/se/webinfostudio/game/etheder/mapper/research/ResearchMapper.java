package se.webinfostudio.game.etheder.mapper.research;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.core.UnitType;
import se.webinfostudio.game.etheder.entity.research.Research;

public class ResearchMapper implements RowMapper<Research> {

	@Override
	public Research map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final Research research = new Research();
		research.setCostFood(rs.getLong("costfood"));
		research.setCostGold(rs.getLong("costgold"));
		research.setCostIron(rs.getLong("costiron"));
		research.setCostStone(rs.getLong("coststone"));
		research.setCostWood(rs.getLong("costwood"));
		research.setDescription(rs.getString("description"));
		research.setId(rs.getLong("id"));
		research.setLevel(rs.getInt("researchlevel"));
		research.setName(rs.getString("name"));
		research.setTicks(rs.getInt("ticks"));
		research.setUnitType(UnitType.valueOf(rs.getString("unittype")));
		return research;
	}

}
