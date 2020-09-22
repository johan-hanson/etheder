package se.webinfostudio.game.etheder.dao.unit;

import java.util.Optional;

import se.webinfostudio.game.etheder.entity.unit.UnitData;

public class UnitDataManualDAO {

	public Optional<UnitData> findById(final Long unitId) {
//		return Optional.ofNullable(getSession().find(UnitData.class, unitId));
		return Optional.empty();
	}

	public UnitData persist(final UnitData unitData) {
//		return super.persist(unitData);
		return null;
	}

}
