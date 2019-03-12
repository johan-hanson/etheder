package se.webinfostudio.game.etheder.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import io.dropwizard.hibernate.UnitOfWork;
import se.webinfostudio.game.etheder.dao.research.ResearchManualDAO;
import se.webinfostudio.game.etheder.entity.research.Research;

public class ResearchService {

	@Inject
	private ResearchManualDAO researchManualDAO;

	@UnitOfWork
	public void importData(final List<Research> researches) {
		try {
			final Optional<Research> research = researchManualDAO.findById(Long.valueOf(1));
			if (!research.isPresent()) {
				researches.forEach(researchManualDAO::persist);
			}
		} finally {
			researchManualDAO.closeSession();
		}
	}
}
