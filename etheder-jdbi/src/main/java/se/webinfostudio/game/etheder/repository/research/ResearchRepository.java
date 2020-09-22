package se.webinfostudio.game.etheder.repository.research;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.research.Research;

@JdbiRepository
@InTransaction
public interface ResearchRepository {

	@SqlUpdate("insert into research(id, name, description, costFood, costGold, costIron, costStone, costWood, researchlevel, ticks, unitType) values(:id, :name, :description, :costFood, :costGold, :costIron, :costStone, :costWood, :level, :ticks, :unitType)")
	void create(@BindBean Research research);

	@SqlQuery("select * from research where id = :id")
	Research findById(@Bind("id") Long id);
}
