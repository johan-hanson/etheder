package se.webinfostudio.game.etheder.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import se.webinfostudio.game.etheder.entity.building.BuildingData;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.entity.util.BuildingDataTestFactory;
import se.webinfostudio.game.etheder.entity.util.PlayerTestFactory;

public class WalletServiceTest {

	@SuppressWarnings("unused")
	private static Stream<Arguments> generatePlayerAndToExpensiveBuilding() {
		return Stream.of(
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostFood(2000L).build()),
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostGold(2000L)
								.build()),
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostIron(2000L)
								.build()),
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostStone(2000L)
								.build()),
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostWood(3000L)
								.build()));
	}

	@SuppressWarnings("unused")
	private static Stream<Arguments> generatePlayerBuldingAndExpectedValues() {
		return Stream.of(
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder().build(),
						PlayerTestFactory.newBuilder()
								.withFood(0L)
								.build()),
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostGold(1000L)
								.build(),
						PlayerTestFactory.newBuilder()
								.withFood(0L)
								.withGold(0L)
								.build()),
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostIron(1000L)
								.build(),
						PlayerTestFactory.newBuilder()
								.withFood(0L)
								.withIron(0L)
								.build()),
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostStone(1000L)
								.build(),
						PlayerTestFactory.newBuilder()
								.withFood(0L)
								.withStone(0L)
								.build()),
				Arguments.of(
						PlayerTestFactory.newBuilder().build(),
						BuildingDataTestFactory.newBuilder()
								.withCostWood(1000L)
								.build(),
						PlayerTestFactory.newBuilder()
								.withFood(0L)
								.withWood(0L)
								.build()));
	}

	private WalletService sut;

	@BeforeEach
	void beforeEach() {
		sut = new WalletService();
	}

	@ParameterizedTest
	@MethodSource("generatePlayerBuldingAndExpectedValues")
	void pay_good(final Player player, final BuildingData building, final Player expected) {
		sut.pay(player, building);

		assertThat(player.getFood()).isEqualTo(expected.getFood());
		assertThat(player.getGold()).isEqualTo(expected.getGold());
		assertThat(player.getIron()).isEqualTo(expected.getIron());
		assertThat(player.getStone()).isEqualTo(expected.getStone());
		assertThat(player.getWood()).isEqualTo(expected.getWood());
	}

	@ParameterizedTest
	@MethodSource("generatePlayerAndToExpensiveBuilding")
	void pay_notAfford(final Player player, final BuildingData building) {
		assertThatThrownBy(() -> sut.pay(player, building))
				.isInstanceOf(IllegalArgumentException.class);
	}
}