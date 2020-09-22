package se.webinfostudio.game.etheder.repository.player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.player.Player;

@JdbiRepository
@InTransaction
public interface PlayerRepository {

	@SqlQuery("select * from player where id = :id")
	Player findById(@Bind("id") final UUID id);

	@SqlQuery("select * from player where userid = :userId")
	Optional<Player> findByUserId(@Bind("userId") final UUID userId);

	@SqlQuery("select * from player")
	List<Player> findAll();

	@SqlUpdate("insert into player(id, country, name, archerTechLevel, cavalryTechLevel, infantryTechLevel, siegeTechLevel, food, wood, gold, iron, stone, userid) "
			+ "values(:id, :country, :name, :archerTechLevel, :cavalryTechLevel, :infantryTechLevel, :siegeTechLevel, :food, :wood, :gold, :iron, :stone, :userId)")
	void create(@BindBean Player player);

	@SqlUpdate("UPDATE player SET archerTechLevel = :archerTechLevel, cavalryTechLevel = :cavalryTechLevel, infantryTechLevel = :infantryTechLevel, siegeTechLevel = :siegeTechLevel, food = :food, wood = :wood, gold = :gold, iron = :iron, stone = :stone WHERE id = :id")
	void update(@BindBean Player player);
}
