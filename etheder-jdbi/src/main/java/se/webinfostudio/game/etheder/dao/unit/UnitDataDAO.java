package se.webinfostudio.game.etheder.dao.unit;

import java.util.Optional;

import se.webinfostudio.game.etheder.entity.unit.UnitData;

/**
 *
 * @author Johan Hanson
 *
 */
public class UnitDataDAO {

	public Optional<UnitData> findById(final Long unitId) {
//		return ofNullable(currentSession().find(UnitData.class, unitId));
		return Optional.empty();
	}

	public UnitData persist(final UnitData unitData) {
//		return super.persist(unitData);
		return null;
	}
}
