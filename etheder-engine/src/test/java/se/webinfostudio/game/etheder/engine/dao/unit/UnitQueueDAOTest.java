package se.webinfostudio.game.etheder.engine.dao.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUnitData;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUnitQueue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.entity.unit.UnitQueue;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class UnitQueueDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(UnitQueue.class)
			.addEntityClass(UnitData.class).build();

	private UnitQueueDAO sut;
	private TestDAO testDAO;

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

	@BeforeEach
	void before() {
		sut = new UnitQueueDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	void decreaseTicks() {
		final UnitQueue unitQueue = createUnitQueue();
		final UnitData unitData = createUnitData();
		unitQueue.setUnit((UnitData) testDAO.persist(unitData));
		testDAO.persist(unitQueue);
		final int result = database.inTransaction(() -> {
			return sut.decreaseTicks();
		});

		assertThat(result).isEqualTo(1);
	}

}
