package se.webinfostudio.game.etheder.repository.research;

import java.util.List;
import java.util.UUID;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

@JdbiRepository
@InTransaction
public interface ResearchQueueRepository {

	@SqlUpdate("insert into researchqueue(id, ticks, indexid, playerid, researchid) values(:id, :ticks, 0, :playerId, :researchId)")
	void create(@BindBean ResearchQueue researchQueue);

	@SqlQuery("select * from researchqueue where id = :id")
	ResearchQueue findById(@Bind("id") UUID id);

	@SqlUpdate("UPDATE researchqueue SET ticks = ticks-1 WHERE ticks>0")
	int decreaseTicks();

	@SqlQuery("SELECT * from ResearchQueue where ticks = 0")
	List<ResearchQueue> findAllFinished();

	@SqlUpdate("DELETE FROM researchqueue WHERE id = :id")
	int remove(@Bind("id") UUID id);
}
