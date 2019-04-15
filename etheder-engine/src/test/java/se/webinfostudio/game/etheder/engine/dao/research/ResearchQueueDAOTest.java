package se.webinfostudio.game.etheder.engine.dao.research;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.buildResearch;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearch;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearchQueue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class ResearchQueueDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(ResearchQueue.class)
			.addEntityClass(Research.class).build();

	private ResearchQueueDAO sut;
	private TestDAO testDAO;

	@BeforeEach
	void before() {
		sut = new ResearchQueueDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	void decreaseTicks() {
		final Research research = createResearch();
		testDAO.persist(research);
		final ResearchQueue researchQueue = createResearchQueue();
		researchQueue.setResearch(research);
		testDAO.persist(researchQueue);
		final int result = database.inTransaction(() -> {
			return sut.decreaseTicks();
		});

		assertThat(result).isEqualTo(1);
	}

	@Test
	void findAllFinished() {
		final Research research1 = buildResearch()
				.withId(1L)
				.build();
		final Research research2 = buildResearch()
				.withId(2L)
				.build();
		final ResearchQueue researchQueue1 = createResearchQueue();
		final ResearchQueue researchQueue2 = createResearchQueue();
		researchQueue1.setResearch(research1);
		researchQueue2.setResearch(research2);
		researchQueue2.setTicks(0);
		testDAO.persist(research1);
		testDAO.persist(research2);
		testDAO.persist(researchQueue1);
		testDAO.persist(researchQueue2);
		final List<ResearchQueue> result = database.inTransaction(() -> {
			return sut.findAllFinished();
		});

		assertThat(result).hasSize(1);
	}

}
