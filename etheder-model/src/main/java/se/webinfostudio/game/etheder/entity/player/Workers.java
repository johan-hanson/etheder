package se.webinfostudio.game.etheder.entity.player;

/**
 * Helper class to sum all workers for a player.
 *
 * @author Johan Hanson
 */
public class Workers {

	private Integer farmers;
	private Integer ironminers;
	private Integer merchants;
	private Integer stonemasons;
	private Integer lumberjacks;

	public void addFarmers(final Integer farmers) {
		setFarmers(farmers + this.farmers);
	}

	public void addIronminers(final Integer ironminers) {
		setIronminers(ironminers + this.ironminers);
	}

	public void addLumberjacks(final Integer lumberjacks) {
		setLumberjacks(lumberjacks + this.lumberjacks);
	}

	public void addMerchants(final Integer merchants) {
		setMerchants(merchants + this.merchants);
	}

	public void addStonemasons(final Integer stonemasons) {
		setStonemasons(stonemasons + this.stonemasons);
	}

	public Integer getFarmers() {
		return farmers;
	}

	public Integer getIronminers() {
		return ironminers;
	}

	public Integer getLumberjacks() {
		return lumberjacks;
	}

	public Integer getMerchants() {
		return merchants;
	}

	public Integer getStonemasons() {
		return stonemasons;
	}

	public void setFarmers(final Integer farmers) {
		this.farmers = farmers;
	}

	public void setIronminers(final Integer ironminers) {
		this.ironminers = ironminers;
	}

	public void setLumberjacks(final Integer lumberjacks) {
		this.lumberjacks = lumberjacks;
	}

	public void setMerchants(final Integer merchants) {
		this.merchants = merchants;
	}

	public void setStonemasons(final Integer stonemasons) {
		this.stonemasons = stonemasons;
	}

}
