package se.webinfostudio.game.etheder.dao.research;

import java.util.Optional;

import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchManualDAO {

	public Optional<Research> findById(final Long researchId) {
//		return Optional.ofNullable(getSession().find(Research.class, researchId));
		return Optional.empty();
	}

	public Research persist(final Research research) {
//		return super.persist(research);
		return null;
	}

}
