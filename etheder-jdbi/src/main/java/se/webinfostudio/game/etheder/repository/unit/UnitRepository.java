package se.webinfostudio.game.etheder.repository.unit;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;

@JdbiRepository
@InTransaction
public interface UnitRepository {

	@SqlQuery("select name from something where id = :id")
	String findNameById(@Bind("id") int id);
}
