package se.webinfostudio.game.etheder.dao;

import se.webinfostudio.game.etheder.entity.AbstractBasicEntity;

/**
 * Helper class to store entities for testing.
 *
 * @author Johan Hanson
 *
 */
public class TestDAO {

	public TestDAO() {
	}

	public AbstractBasicEntity persist(final AbstractBasicEntity entity) {
//		return super.persist(entity);
		return entity;
	}
}
