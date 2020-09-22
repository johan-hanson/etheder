package se.webinfostudio.game.etheder.repository.building;

import java.util.List;
import java.util.UUID;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;

@JdbiRepository
@InTransaction
public interface BuildingQueueRepository {

	@SqlUpdate("insert into buildingqueue(id, ticks, cityid, building_id) values(:id, :ticks, :cityId, :building)")
	void create(@BindBean BuildingQueue buildingQueue);

	@SqlQuery("select * from buildingqueue where id = :id")
	BuildingQueue findById(@Bind("id") UUID id);

	@SqlUpdate("UPDATE BuildingQueue SET ticks = ticks-1 WHERE ticks>0")
	int decreaseTicks();

	@SqlQuery("SELECT * from buildingqueue where ticks = 0")
	List<BuildingQueue> findAllFinished();

	@SqlUpdate("DELETE FROM BuildingQueue WHERE id = :id")
	int remove(@Bind("id") UUID id);
}
