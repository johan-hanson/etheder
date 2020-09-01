package se.webinfostudio.game.etheder.dao.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUnitData;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class UnitDataDAOTest {

	private UnitDataDAO sut;

	@BeforeEach
	void before() {
		sut = new UnitDataDAO();
	}

	void findById() {
		final UnitData unitData = createUnitData();
		sut.persist(unitData);
		final Optional<UnitData> result = sut.findById(unitData.getId());

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getId()).isEqualTo(unitData.getId());
	}

	void persist() {
		final UnitData unitData = createUnitData();
		final UnitData result = sut.persist(unitData);

		assertThat(result.getId()).isEqualTo(unitData.getId());
	}
}
