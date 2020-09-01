package se.webinfostudio.game.etheder.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.repository.research.ResearchRepository;

public class ResearchImportService {

	@Inject
	private ResearchRepository researchRepository;

	public void importData(final List<Research> researches) {
		try {
			final Optional<Research> research = Optional.ofNullable(researchRepository.findById(Long.valueOf(1)));
			if (!research.isPresent()) {
				researches.forEach(researchRepository::create);
			}
		} finally {
		}
	}
}
