package se.webinfostudio.game.etheder.dao.research;

import java.util.Optional;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import se.webinfostudio.game.etheder.dao.AbstractManualDAO;
import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchManualDAO extends AbstractManualDAO<Research> {

	@Inject
	public ResearchManualDAO(final SessionFactory sessionFactory) {
		super(sessionFactory, Research.class);
	}

	public Optional<Research> findById(final Long researchId) {
		return Optional.ofNullable(getSession().find(Research.class, researchId));
	}

	@Override
	public Research persist(final Research research) {
		return super.persist(research);
	}

}
