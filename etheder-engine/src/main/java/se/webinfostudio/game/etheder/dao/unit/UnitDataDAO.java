package se.webinfostudio.game.etheder.dao.unit;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

/**
 *
 * @author Johan Hanson
 *
 */
public class UnitDataDAO extends AbstractDAO<UnitData> {

	@Inject
	public UnitDataDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Optional<UnitData> findById(final Long unitId) {
		return ofNullable(currentSession().find(UnitData.class, unitId));
	}

	@Override
	public UnitData persist(final UnitData unitData) {
		return super.persist(unitData);
	}
}
