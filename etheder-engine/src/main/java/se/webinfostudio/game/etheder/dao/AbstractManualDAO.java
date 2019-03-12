package se.webinfostudio.game.etheder.dao;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class AbstractManualDAO<E> {

	private final Session session;
	private final Class<E> entityClass;

	public AbstractManualDAO(final SessionFactory sessionFactory, final Class<E> entityClass) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		this.entityClass = entityClass;
	}

	public void closeSession() {
		final Transaction transaction = session.getTransaction();
		if (transaction.getRollbackOnly()) {
			transaction.rollback();
		} else {
			transaction.commit();
		}
		session.close();
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

	protected E persist(final E entity) throws HibernateException {
		session.saveOrUpdate(requireNonNull(entity));
		return entity;
	}
}
