package se.webinfostudio.game.etheder.entity;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Johan Hanson
 */
public abstract class AbstractQueueEntity extends AbstractGameEntity {

	private static final long serialVersionUID = 4087861525169429546L;

	/**
	 * Ticks before the building is finsihed
	 */
	@NotNull
	private Integer ticks;

	public Integer getTicks() {
		return ticks;
	}

	public void setTicks(final Integer ticks) {
		this.ticks = ticks;
	}
}
