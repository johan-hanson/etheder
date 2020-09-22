package se.webinfostudio.game.etheder.repository.user;

import java.util.Optional;
import java.util.UUID;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.user.User;

@JdbiRepository
@InTransaction
public interface UserRepository {

	@SqlQuery("select * from users where email = :email")
	public Optional<User> findByEmail(@Bind("email") final String email);

	@SqlQuery("select * from users where id = :id")
	public User findById(@Bind("id") final UUID id);

	@SqlQuery("select * from users where loginId = :loginId")
	public User findByLoginId(@Bind("loginId") final UUID loginId);

	@SqlUpdate("insert into users(id, age, country, email, firstname, lastname, loginid) values(:id, :age, :country, :email, :firstName, :lastName, :loginId)")
	void create(@BindBean User user);
}
