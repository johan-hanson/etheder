package se.webinfostudio.game.etheder.mapper.player;

import static java.lang.String.format;
import static se.webinfostudio.game.etheder.entity.player.CityLevel.valueOf;
import static se.webinfostudio.game.etheder.repository.utils.ResultSetUtils.getUUID;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import se.webinfostudio.game.etheder.entity.player.City;

public class CityMapper implements RowMapper<City> {

	@Override
	public City map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final City city = new City();
		city.setId(getUUID(rs, "id"));
		city.setName(rs.getString("name"));
		city.setAcres(rs.getInt("acres"));
		city.setCityLevel(valueOf(format("LEVEL%s", rs.getInt("citylevel")))); // converter???
		city.setFarmers(rs.getInt("farmers"));
		city.setIronminers(rs.getInt("ironminers"));
		city.setLumberjacks(rs.getInt("lumberjacks"));
		city.setMerchants(rs.getInt("merchants"));
		city.setPopulation(rs.getLong("population"));
		city.setStonemasons(rs.getInt("stonemasons"));
		city.setPlayerId(getUUID(rs, "playerid"));
		return city;
	}

}
