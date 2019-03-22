package se.webinfostudio.game.etheder.engine.dao.research;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearchQueue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.dao.TestDAO;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class ResearchQueueDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(ResearchQueue.class).build();

	private ResearchQueueDAO sut;
	private TestDAO testDAO;

	@BeforeEach
	void before() {
		sut = new ResearchQueueDAO(database.getSessionFactory().getCurrentSession());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	void decreaseTicks() {
		final ResearchQueue researchQueue = createResearchQueue();
		testDAO.persist(researchQueue);
		final int result = database.inTransaction(() -> {
			return sut.decreaseTicks();
		});

		assertThat(result).isEqualTo(1);
	}

	@Test
	void findAllFinished() {
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
