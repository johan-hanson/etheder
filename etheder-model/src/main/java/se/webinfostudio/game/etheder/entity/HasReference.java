package se.webinfostudio.game.etheder.entity;

/**
 * .
 *
 * @author Johan Hanson
 * @param <R> an interface that extends {@link EntityBasicReference} of the type
 *        implementing this interface.
 */
public interface HasReference<R extends EntityBasicReference> {

	/**
	 * Returns a reference to the entity.
	 *
	 * @return a reference
	 */
	R toRef();
}
