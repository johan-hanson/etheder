package se.webinfostudio.game.etheder.repository.user;

import java.util.Optional;
import java.util.UUID;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import ru.vyarus.guicey.jdbi3.installer.repository.JdbiRepository;
import ru.vyarus.guicey.jdbi3.tx.InTransaction;
import se.webinfostudio.game.etheder.entity.user.Login;

@JdbiRepository
@InTransaction
public interface LoginRepository {

	@SqlUpdate("insert into logins(id, userName, passwordHash) values(:id, :userName, :passwordHash)")
	void create(@BindBean Login login);

	@SqlUpdate("update logins set token = :token, tokenexpiredate = :tokenExpireDate where id = :id")
	void updateToken(@BindBean Login login);

	@SqlQuery("select * from logins where userName = :userName")
	public Optional<Login> findByUserName(@Bind("userName") final String userName);

	@SqlQuery("select * from logins where token = :token")
	Optional<Login> findByToken(@Bind("token") final UUID token);

}
