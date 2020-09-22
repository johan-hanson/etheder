package se.webinfostudio.game.etheder.mapper.player;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.repository.utils.ResultSetUtils;

public class PlayerMapper implements RowMapper<Player> {

	@Override
	public Player map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final Player player = new Player();
		player.setId(ResultSetUtils.getUUID(rs, "id"));
		player.setCountry(rs.getString("country"));
		player.setName(rs.getString("name"));
		player.setArcherTechLevel(rs.getInt("archerTechLevel"));
		player.setCavalryTechLevel(rs.getInt("cavalryTechLevel"));
		player.setInfantryTechLevel(rs.getInt("infantryTechLevel"));
		player.setSiegeTechLevel(rs.getInt("siegeTechLevel"));
		player.setFood(rs.getLong("food"));
		player.setWood(rs.getLong("wood"));
		player.setGold(rs.getLong("gold"));
		player.setIron(rs.getLong("iron"));
		player.setStone(rs.getLong("stone"));
		player.setUserId(ResultSetUtils.getUUID(rs, "userid"));
		return player;
	}

}
