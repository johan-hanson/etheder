package se.webinfostudio.game.etheder.dao.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUnitData;

import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.DAOTestRule;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

/**
 * DAO test classes need JUnit 4 for DAOTestRule to work.
 *
 * @author Johan Hanson
 *
 */
public class UnitDataManualDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(UnitData.class)
			.build();

	private UnitDataManualDAO sut;

	@Before
	public void before() {
		sut = new UnitDataManualDAO(database.getSessionFactory());
	}

	@Test
	public void findById() {
		final UnitData research = createUnitData();
		sut.persist(research);
		final Optional<UnitData> result = sut.findById(research.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(research.getId());
	}

	@Test
	public void persist() {
		final UnitData research = createUnitData();
		final UnitData result = sut.persist(research);

		assertThat(result.getId()).isEqualTo(research.getId());
	}
}
