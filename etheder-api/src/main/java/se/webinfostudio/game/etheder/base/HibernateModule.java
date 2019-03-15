package se.webinfostudio.game.etheder.base;

import org.hibernate.SessionFactory;

import com.google.inject.Provides;
import com.google.inject.Singleton;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import se.webinfostudio.game.etheder.ApiConfiguration;
import se.webinfostudio.game.etheder.entity.building.Building;
import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.building.BuildingQueue;
import se.webinfostudio.game.etheder.entity.building.BuildingRef;
import se.webinfostudio.game.etheder.entity.player.Army;
import se.webinfostudio.game.etheder.entity.player.ArmyRef;
import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Login;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.player.User;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;
import se.webinfostudio.game.etheder.entity.unit.Unit;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class HibernateModule extends DropwizardAwareModule<ApiConfiguration> {

	/**
	 * Returns a new instance of {@code HibernateModule}.
	 *
	 * @return a new instance of {@code HibernateModule}.
	 */
	public static HibernateModule hibernateModule(final Bootstrap<ApiConfiguration> bootstrap) {
		return new HibernateModule(bootstrap);
	}

	private final HibernateBundle<ApiConfiguration> hibernate = new HibernateBundle<ApiConfiguration>(
			Army.class, ArmyRef.class, Building.class, BuildingData.class, BuildingQueue.class, BuildingRef.class,
			City.class, User.class, Login.class, Player.class, Research.class, ResearchQueue.class,
			Unit.class, UnitData.class, UnitQueue.class) {
		@Override
		public DataSourceFactory getDataSourceFactory(final ApiConfiguration configuration) {
			return configuration.getDataSourceFactory();
		}
	};

	private HibernateModule(final Bootstrap<ApiConfiguration> bootstrap) {
		bootstrap.addBundle(hibernate);
	}

	@Provides
	@Singleton
	protected HibernateBundle<ApiConfiguration> providesHibernateBundle() {
		return hibernate;
	}

	@Provides
	@Singleton
	protected SessionFactory providesSessionFactory() {
		return hibernate.getSessionFactory();
	}

//	@Provides
//	@Singleton
//	protected UnitDataDAO providesUnitDataDAO(final SessionFactory sessionFactory) {
//		// not working sessionFactory is null
//		return new UnitOfWorkAwareProxyFactory(hibernate).create(UnitDataDAO.class, SessionFactory.class,
//				sessionFactory);
//	}

}
