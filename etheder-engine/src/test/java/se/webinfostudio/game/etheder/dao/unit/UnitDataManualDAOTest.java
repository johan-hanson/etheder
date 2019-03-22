package se.webinfostudio.game.etheder.dao.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUnitData;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DAOTestExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class UnitDataManualDAOTest {

	DAOTestExtension database = DAOTestExtension.newBuilder()
			.addEntityClass(UnitData.class)
			.build();

	private UnitDataManualDAO sut;

	@BeforeEach
	void before() {
		sut = new UnitDataManualDAO(database.getSessionFactory());
	}

	@Test
	void findById() {
		final UnitData research = createUnitData();
		sut.persist(research);
		final Optional<UnitData> result = sut.findById(research.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(research.getId());
	}

	@Test
	void persist() {
		final UnitData research = createUnitData();
		final UnitData result = sut.persist(research);

		assertThat(result.getId()).isEqualTo(research.getId());
	}
}
