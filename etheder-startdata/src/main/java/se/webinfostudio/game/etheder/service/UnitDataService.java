package se.webinfostudio.game.etheder.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.dao.unit.UnitDataManualDAO;
import se.webinfostudio.game.etheder.entity.unit.UnitData;

/**
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
@Named
public class UnitDataService {

	@Inject
	private UnitDataManualDAO unitDataManualDAO;

//	@UnitOfWork
//	public void importData(final List<UnitData> units) {
//		final Optional<UnitData> unit = unitDataDAO.findById(Long.valueOf(1));
//		if (!unit.isPresent()) {
//			units.forEach(unitDataDAO::persist);
//		}
//	}

//	@UnitOfWork
	public void importData(final List<UnitData> units) {
		try {
			final Optional<UnitData> unit = unitDataManualDAO.findById(Long.valueOf(1));
			if (!unit.isPresent()) {
				units.forEach(unitDataManualDAO::persist);
			}
		} finally {
			unitDataManualDAO.closeSession();
		}
	}
}
