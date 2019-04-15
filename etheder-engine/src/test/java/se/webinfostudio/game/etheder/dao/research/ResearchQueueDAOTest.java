package se.webinfostudio.game.etheder.dao.research;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearchQueue;

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
		sut = new ResearchQueueDAO(database.getSessionFactory());
		testDAO = new TestDAO(database.getSessionFactory());
	}

	@Test
	void persist() {
		final ResearchQueue researchQueue = createResearchQueue();
		researchQueue.setResearch((Research) testDAO.persist(researchQueue.getResearch()));
		final ResearchQueue result = sut.persist(researchQueue);

		assertThat(result.getId()).isEqualTo(researchQueue.getId());
	}

}
