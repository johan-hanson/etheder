package se.webinfostudio.game.etheder.repository.building;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.building.Building;

@JdbiRepository
@InTransaction
public interface BuildingRepository {

	@SqlQuery("select name from something where id = :id")
	String findNameById(@Bind("id") int id);

	@SqlUpdate("insert into building(id, buildingdata_id) values(:id, :buildingDataId)")
	void create(@BindBean Building building);
}
