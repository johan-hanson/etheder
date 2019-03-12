package se.webinfostudio.game.etheder.engine.dao.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUnitData;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUnitQueue;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class UnitQueueDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(UnitQueue.class)
			.addEntityClass(UnitData.class).build();

	private UnitQueueDAO sut;
	private TestDAO testDAO;

	@Before
	public void before() {
		sut = new UnitQueueDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	public void decreaseTicks() {
		final UnitQueue unitQueue = createUnitQueue();
		final UnitData unitData = createUnitData();
		unitQueue.setUnit((UnitData) testDAO.persist(unitData));
		testDAO.persist(unitQueue);
		final int result = database.inTransaction(() -> {
			return sut.decreaseTicks();
		});

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void findAllFinished() {
		final UnitQueue unitQueue1 = createUnitQueue();
		final UnitQueue unitQueue2 = createUnitQueue();
		final UnitData unitData = createUnitData();
		unitQueue1.setUnit((UnitData) testDAO.persist(unitData));
		unitQueue2.setUnit(unitQueue1.getUnit());
		unitQueue2.setTicks(0);
		testDAO.persist(unitQueue1);
		testDAO.persist(unitQueue2);
		final List<UnitQueue> result = database.inTransaction(() -> {
			return sut.findAllFinished();
		});

		assertThat(result).hasSize(1);
	}

}
