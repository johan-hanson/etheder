package se.webinfostudio.game.etheder.dao.research;

import java.util.Optional;

import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchDAO {

	public Optional<Research> findById(final Long researchId) {
//		return ofNullable(currentSession().find(Research.class, researchId));
		return Optional.empty();
	}

	public Research persist(final Research entity) {
//		return super.persist(entity);
		return null;
	}

}
