package se.webinfostudio.game.etheder.repository.unit;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

@JdbiRepository
@InTransaction
public interface UnitDataRepository {

	@SqlUpdate("insert into unitdata(id, name, description, costFood, costGold, costIron, costStone, costWood, attack, armour, defensive, health, speed, unitlevel, ticks, unitType) values(:id, :name, :description, :costFood, :costGold, :costIron, :costStone, :costWood, :attack, :armour, :defensive, :health, :speed, :level, :ticks, :unitType)")
	void create(@BindBean UnitData unitData);

	@SqlQuery("select * from unitdata where id = :id")
	UnitData findById(@Bind("id") Long id);
}
