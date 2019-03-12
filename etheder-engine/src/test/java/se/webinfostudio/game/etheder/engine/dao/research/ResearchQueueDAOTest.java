package se.webinfostudio.game.etheder.engine.dao.research;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearchQueue;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class ResearchQueueDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(ResearchQueue.class).build();

	private ResearchQueueDAO sut;
	private TestDAO testDAO;

	@Before
	public void before() {
		sut = new ResearchQueueDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	public void decreaseTicks() {
		final ResearchQueue researchQueue = createResearchQueue();
		testDAO.persist(researchQueue);
		final int result = database.inTransaction(() -> {
			return sut.decreaseTicks();
		});

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void findAllFinished() {
		final ResearchQueue researchQueue1 = createResearchQueue();
		final ResearchQueue researchQueue2 = createResearchQueue();
		researchQueue2.setTicks(0);
		testDAO.persist(researchQueue1);
		testDAO.persist(researchQueue2);
		final List<ResearchQueue> result = database.inTransaction(() -> {
			return sut.findAllFinished();
		});

		assertThat(result).hasSize(1);
	}

}
