package se.webinfostudio.game.etheder.dao;

@Deprecated
public abstract class AbstractManualDAO<E> {

	private final Class<E> entityClass;

	public AbstractManualDAO(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}
}
