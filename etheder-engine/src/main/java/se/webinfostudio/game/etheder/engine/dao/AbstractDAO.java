package se.webinfostudio.game.etheder.engine.dao;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.Validate.notNull;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import se.webinfostudio.game.etheder.entity.AbstractBasicEntity;
import se.webinfostudio.game.etheder.entity.EntityBasicReference;

public abstract class AbstractDAO<E extends AbstractBasicEntity> {

	private final Session session;
	private final Class<E> entityClass;

	public AbstractDAO(final Session session, final Class<E> entityClass) {
		this.session = session;
		this.entityClass = entityClass;
	}

	public <R extends EntityBasicReference> E findByRef(final R r) {
		notNull(r);

		try {
			return session.find(entityClass, r.getId());
		} catch (final IllegalArgumentException e) {
			return null;
		}
	}

	public E persist(final E entity) throws HibernateException {
		session.saveOrUpdate(requireNonNull(entity));
		return entity;
	}

	public void remove(final E entity) {
		session.remove(requireNonNull(entity));
	}

	/**
	 * Return all T.
	 *
	 * @param namedQuery the named query
	 * @param params     parameters for query
	 * @return a list of entities T
	 */
	protected List<E> findByNamedQuery(final String namedQuery, final Object... params) {
		final TypedQuery<E> typedQuery = session.createNamedQuery(namedQuery, entityClass);
		int index = 1;
		for (final Object param : params) {
			typedQuery.setParameter(index++, param);
		}
		return typedQuery.getResultList();
	}

	protected Session getSession() {
		return session;
	}

	/**
	 * Runs a named query.
	 *
	 * @param namedQuery the named query
	 * @return number of rows inserted/updated
	 */
	protected int insertUpdateNamedQuery(final String namedQuery) {
		return session.createNamedQuery(namedQuery).executeUpdate();
	}
}
