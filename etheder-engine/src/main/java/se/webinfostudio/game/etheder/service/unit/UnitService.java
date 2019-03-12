package se.webinfostudio.game.etheder.service.unit;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.unit.Unit;

/**
 *
 * @author Johan Hanson
 */
@Named
public class UnitService implements Serializable {

	private static final long serialVersionUID = -1326931050472330891L;

	/**
	 * unitRepository the repository for Unit.
	 */
//	@Inject
//	private UnitRepository unitRepository;

	/**
	 * Returns all units.
	 *
	 * @return a list of units
	 */
	public List<Unit> findAll() {
//		return unitRepository.findAll();
		return null;
	}

	/**
	 * Gets an unit by its id.
	 *
	 * @param unitId the id of the unit
	 * @return the unit
	 */
	public Unit findById(final Long unitId) {
//		return (Unit) unitRepository.findById(unitId);
		return null;
	}

	/**
	 * Saves a list of units.
	 *
	 * @param units a list of units
	 * @return the saved list of units
	 */
	public List<Unit> save(final List<Unit> units) {
		for (final Unit unit : units) {
//			unitRepository.create(unit);
		}
		return units;
	}
}
