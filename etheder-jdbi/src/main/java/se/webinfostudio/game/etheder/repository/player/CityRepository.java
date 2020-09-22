package se.webinfostudio.game.etheder.repository.player;

import java.util.List;
import java.util.UUID;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.player.City;

@JdbiRepository
@InTransaction
public interface CityRepository {

	@SqlQuery("select * from city where id = :id")
	City findById(@Bind("id") final UUID id);

	@SqlQuery("select * from city where playerId = :playerId")
	List<City> findAllByPlayerId(@Bind("playerId") UUID playerId);

	@SqlUpdate("insert into city(id, acres, citylevel, farmers, ironminers, lumberjacks, merchants, name, population, stonemasons, playerid) "
			+ "values(:id, :acres, :level, :farmers, :ironminers, :lumberjacks, :merchants, :name, :population, :stonemasons, :playerId)")
	void create(@BindBean City city);

	@SqlUpdate("UPDATE city SET acres = :acres, level = :level, farmers = :farmers, ironminers = :ironminers, lumberjacks= :lumberjacks, merchants = :merchants, population = :population, stonemasons = :stonemasons WHERE id = :id")
	void update(@BindBean City city);

}
