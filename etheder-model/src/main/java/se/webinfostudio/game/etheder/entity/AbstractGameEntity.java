package se.webinfostudio.game.etheder.entity;

import static java.util.UUID.randomUUID;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Used for common game entity stuff.
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
@MappedSuperclass
public abstract class AbstractGameEntity extends AbstractBasicEntity {

	private static final long serialVersionUID = -2793096981308984347L;

	@Id
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
