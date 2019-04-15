package se.webinfostudio.game.etheder.dao.research;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.research.Research;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchDAO extends AbstractDAO<Research> {

	@Inject
	public ResearchDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Optional<Research> findById(final Long researchId) {
		return ofNullable(currentSession().find(Research.class, researchId));
	}

	@Override
	public Research persist(final Research entity) {
		return super.persist(entity);
	}

}
