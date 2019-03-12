package se.webinfostudio.game.etheder.service.research;

import java.util.List;

import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 */
@Named
public class ResearchService {

//	@Inject
//	private ResearchRepository researchRepository;

	/**
	 * Finds all researches.
	 *
	 * @return a list of researches
	 */
	public List<Research> findAll() {
//		return researchRepository.findAll();
		return null;
	}

	/**
	 * Find a research by its id.
	 *
	 * @param researchId the research id
	 * @return {@link Research}
	 */
	public Research findById(final Long researchId) {
//		return (Research) researchRepository.findById(researchId);
		return null;
	}

	/**
	 * Saves a list of Researches.
	 *
	 * @param researches a list of Research
	 * @return a list of researches
	 */
	public List<Research> save(final List<Research> researches) {
		for (final Research research : researches) {
//			researchRepository.create(research);
		}
		return researches;
	}
}
