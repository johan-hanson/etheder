package se.webinfostudio.game.etheder.dao;

import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;
import se.webinfostudio.game.etheder.entity.AbstractBasicEntity;

/**
 * Helper class to store entities for testing.
 *
 * @author Johan Hanson
 *
 */
public class TestDAO extends AbstractDAO<AbstractBasicEntity> {

	public TestDAO(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public AbstractBasicEntity persist(final AbstractBasicEntity entity) {
		return super.persist(entity);
	}
}
