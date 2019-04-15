package se.webinfostudio.game.etheder.dao.research;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createResearch;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class ResearchDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(Research.class).build();

	private ResearchDAO sut;

	@BeforeEach
	void before() {
		sut = new ResearchDAO(database.getSessionFactory());
	}

	@Test
	void findById() {
		final Research research = createResearch();
		sut.persist(research);
		final Optional<Research> result = sut.findById(research.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(research.getId());
		assertThat(result.get().getName()).isEqualTo(research.getName());
	}

	@Test
	void persist() {
		final Research research = createResearch();
		final Research result = sut.persist(research);

		assertThat(result.getId()).isEqualTo(research.getId());
		assertThat(result.getName()).isEqualTo(research.getName());
	}

}
