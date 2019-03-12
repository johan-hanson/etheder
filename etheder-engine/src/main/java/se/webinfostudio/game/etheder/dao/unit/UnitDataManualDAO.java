package se.webinfostudio.game.etheder.dao.unit;

import java.util.Optional;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import se.webinfostudio.game.etheder.dao.AbstractManualDAO;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

public class UnitDataManualDAO extends AbstractManualDAO<UnitData> {

	@Inject
	public UnitDataManualDAO(final SessionFactory sessionFactory) {
		super(sessionFactory, UnitData.class);
	}

	public Optional<UnitData> findById(final Long unitId) {
		return Optional.ofNullable(getSession().find(UnitData.class, unitId));
	}

	@Override
	public UnitData persist(final UnitData unitData) {
		return super.persist(unitData);
	}

}
