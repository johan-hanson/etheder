package se.webinfostudio.game.etheder.repository.building;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.building.BuildingData;

@JdbiRepository
@InTransaction
public interface BuildingDataRepository {

	@SqlUpdate("insert into buildingdata(id, name, description, costFood, costGold, costIron, costStone, costWood, maxNumber, populationCapacity, ticks, unitType) values(:id, :name, :description, :costFood, :costGold, :costIron, :costStone, :costWood, :maxNumber, :populationCapacity, :ticks, :unitType)")
	void create(@BindBean BuildingData buildingData);

	@SqlQuery("select * from buildingdata where id = :id")
	BuildingData findById(@Bind("id") Long id);
}
