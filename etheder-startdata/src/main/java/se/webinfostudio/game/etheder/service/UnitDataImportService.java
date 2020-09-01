package se.webinfostudio.game.etheder.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.unit.UnitData;
import se.webinfostudio.game.etheder.repository.unit.UnitDataRepository;

/**
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
@Named
public class UnitDataImportService {

	@Inject
	private UnitDataRepository unitDataRepository;

	public void importData(final List<UnitData> units) {
		try {
			final Optional<UnitData> unit = Optional.ofNullable(unitDataRepository.findById(Long.valueOf(1)));
			if (!unit.isPresent()) {
				units.forEach(unitDataRepository::create);
			}
		} finally {
		}
	}
}
