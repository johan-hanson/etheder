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
public class UnitDataDAOTest {

	@Rule
	public DAOTestRule database = DAOTestRule.newBuilder()
			.addEntityClass(UnitData.class)
			.build();

	private UnitDataDAO sut;

	@Before
	public void before() {
		sut = new UnitDataDAO(database.getSessionFactory());
	}

	@Test
	public void findById() {
		final UnitData unitData = createUnitData();
		sut.persist(unitData);
		final Optional<UnitData> result = sut.findById(unitData.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(unitData.getId());
	}

	@Test
	public void persist() {
		final UnitData unitData = createUnitData();
		final UnitData result = sut.persist(unitData);

		assertThat(result.getId()).isEqualTo(unitData.getId());
	}
}
