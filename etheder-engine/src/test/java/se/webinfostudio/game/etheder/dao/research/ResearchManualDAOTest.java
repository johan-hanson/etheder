package se.webinfostudio.game.etheder.dao.research;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearch;

import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.entity.research.Research;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class ResearchManualDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(Research.class)
			.build();

	private ResearchManualDAO sut;

	@Before
	public void before() {
		sut = new ResearchManualDAO(database.getSessionFactory());
	}

	@Test
	public void findById() {
		final Research research = createResearch();
		sut.persist(research);
		final Optional<Research> result = sut.findById(research.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(research.getId());
	}

	@Test
	public void persist() {
		final Research research = createResearch();
		final Research result = sut.persist(research);

		assertThat(result.getId()).isEqualTo(research.getId());
	}
}
