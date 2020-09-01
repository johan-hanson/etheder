package se.webinfostudio.game.etheder.engine.dao;

import static org.apache.commons.lang3.Validate.notNull;

import java.util.Collections;
import java.util.List;

import se.webinfostudio.game.etheder.entity.AbstractBasicEntity;
import se.webinfostudio.game.etheder.entity.EntityBasicReference;

@Deprecated
public abstract class AbstractDAO<E extends AbstractBasicEntity> {

	private final Class<E> entityClass;

	public AbstractDAO(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public <R extends EntityBasicReference> E findByRef(final R r) {
		notNull(r);

		try {
//			return session.find(entityClass, r.getId());
			return null;
		} catch (final IllegalArgumentException e) {
			return null;
		}
	}

	public E persist(final E entity) {
//		session.saveOrUpdate(requireNonNull(entity));
		return entity;
	}

	public void remove(final E entity) {
//		session.remove(requireNonNull(entity));
	}

	/**
	 * Return all T.
	 *
	 * @param namedQuery the named query
	 * @param params     parameters for query
	 * @return a list of entities T
	 */
	protected List<E> findByNamedQuery(final String namedQuery, final Object... params) {
//		final TypedQuery<E> typedQuery = session.createNamedQuery(namedQuery, entityClass);
//		int index = 1;
//		for (final Object param : params) {
//			typedQuery.setParameter(index++, param);
//		}
//		return typedQuery.getResultList();
		return Collections.emptyList();
	}

	/**
	 * Runs a named query.
	 *
	 * @param namedQuery the named query
	 * @return number of rows inserted/updated
	 */
	protected int insertUpdateNamedQuery(final String namedQuery) {
//		return session.createNamedQuery(namedQuery).executeUpdate();
		return -1;
	}
}
