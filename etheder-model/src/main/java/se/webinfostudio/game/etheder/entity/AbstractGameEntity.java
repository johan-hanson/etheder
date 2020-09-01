package se.webinfostudio.game.etheder.entity;

import static java.util.UUID.randomUUID;

import java.util.UUID;

/**
 * Used for common game entity stuff.
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
public abstract class AbstractGameEntity extends AbstractBasicEntity {

	private static final long serialVersionUID = -2793096981308984347L;

	protected UUID id;

	public AbstractGameEntity() {
		id = randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}
}
