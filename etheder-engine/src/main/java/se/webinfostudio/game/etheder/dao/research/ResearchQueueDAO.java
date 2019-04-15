package se.webinfostudio.game.etheder.dao.research;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchQueueDAO extends AbstractDAO<ResearchQueue> {

	@Inject
	public ResearchQueueDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public ResearchQueue persist(final ResearchQueue researchQueue) {
		return super.persist(researchQueue);
	}
}
