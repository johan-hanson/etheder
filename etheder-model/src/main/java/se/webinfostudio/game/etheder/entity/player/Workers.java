package se.webinfostudio.game.etheder.entity.player;

/**
 * Helper class to sum all workers for a player.
 *
 * @author Johan Hanson
 */
public class Workers {

	private long farmers = 0L;
	private long ironminers = 0L;
	private long merchants = 0L;
	private long stonemasons = 0L;
	private long lumberjacks = 0L;

	public void addFarmers(final long farmers) {
		setFarmers(farmers + this.farmers);
	}

	public void addIronminers(final long ironminers) {
		setIronminers(ironminers + this.ironminers);
	}

	public void addLumberjacks(final long lumberjacks) {
		setLumberjacks(lumberjacks + this.lumberjacks);
	}

	public void addMerchants(final long merchants) {
		setMerchants(merchants + this.merchants);
	}

	public void addStonemasons(final long stonemasons) {
		setStonemasons(stonemasons + this.stonemasons);
	}

	public long getFarmers() {
		return farmers;
	}

	public long getIronminers() {
		return ironminers;
	}

	public long getLumberjacks() {
		return lumberjacks;
	}

	public long getMerchants() {
		return merchants;
	}

	public long getStonemasons() {
		return stonemasons;
	}

	public void setFarmers(final long farmers) {
		this.farmers = farmers;
	}

	public void setIronminers(final long ironminers) {
		this.ironminers = ironminers;
	}

	public void setLumberjacks(final long lumberjacks) {
		this.lumberjacks = lumberjacks;
	}

	public void setMerchants(final long merchants) {
		this.merchants = merchants;
	}

	public void setStonemasons(final long stonemasons) {
		this.stonemasons = stonemasons;
	}

}
