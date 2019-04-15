package se.webinfostudio.game.etheder.service;

import javax.inject.Named;

import se.webinfostudio.game.etheder.entity.AbstractDataEntity;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 */
@Named
public class WalletService {

	/**
	 * Checks if a player can pay for a gameEntity.
	 *
	 * @param player     {@link Player}
	 * @param gameEntity {@link AbstractDataEntity}
	 * @return true if a player can pay for the cost
	 */
	public boolean hasAffored(final Player player, final AbstractDataEntity gameEntity) {
		if (player.getFood() < gameEntity.getCostFood()) {
			return false;
		}
		if (player.getWood() < gameEntity.getCostWood()) {
			return false;
		}
		if (player.getIron() < gameEntity.getCostIron()) {
			return false;
		}
		if (player.getStone() < gameEntity.getCostStone()) {
			return false;
		}
		if (player.getGold() < gameEntity.getCostGold()) {
			return false;
		}
		return true;
	}

	/**
	 * Reduce the cost from a gameEntity from a player.
	 *
	 * @param player     {@link Player}
	 * @param dataEntity {@link AbstractDataEntity}
	 */
	public void pay(final Player player, final AbstractDataEntity dataEntity) {
		if (hasAffored(player, dataEntity)) {
			player.setFood(player.getFood() - dataEntity.getCostFood());
			player.setWood(player.getWood() - dataEntity.getCostWood());
			player.setIron(player.getIron() - dataEntity.getCostIron());
			player.setStone(player.getStone() - dataEntity.getCostStone());
			player.setGold(player.getGold() - dataEntity.getCostGold());
		} else {
			throw new IllegalArgumentException("Player do not affored the cost");
		}
	}
}
