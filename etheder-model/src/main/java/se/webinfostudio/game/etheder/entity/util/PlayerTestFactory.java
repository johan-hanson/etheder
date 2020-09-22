package se.webinfostudio.game.etheder.entity.util;

import static java.util.UUID.randomUUID;

import java.util.UUID;

import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerTestFactory {

	public static final class Builder {
		private UUID id = randomUUID();
		private String country = "Sweden";
		private UUID userId = randomUUID();
		private Long food = 1000L;
		private Long wood = 1000L;
		private Long gold = 1000L;
		private Long iron = 1000L;
		private Long stone = 1000L;

		public Player build() {
			final Player player = new Player();
			player.setId(id);
			player.setCountry(country);
			player.setUserId(userId);
			player.setFood(food);
			player.setWood(wood);
			player.setGold(gold);
			player.setStone(stone);
			player.setIron(iron);
			return player;
		}

		public Builder withCountry(final String country) {
			this.country = country;
			return this;
		}

		public Builder withFood(final Long food) {
			this.food = food;
			return this;
		}

		public Builder withGold(final Long gold) {
			this.gold = gold;
			return this;
		}

		public Builder withId(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder withIron(final Long iron) {
			this.iron = iron;
			return this;
		}

		public Builder withStone(final Long stone) {
			this.stone = stone;
			return this;
		}

		public Builder withUser(final UUID userId) {
			this.userId = userId;
			return this;
		}

		public Builder withWood(final Long wood) {
			this.wood = wood;
			return this;
		}

	}

	public static Builder newBuilder() {
		return new Builder();
	}

	private PlayerTestFactory() {
		// not used
	}

}
