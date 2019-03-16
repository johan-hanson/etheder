package se.webinfostudio.game.etheder.api.transformer.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createPlayerModel;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createPlayerModelNew;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.player.PlayerModel;
import se.webinfostudio.game.etheder.api.transformer.player.PlayerTransformer;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerTransformerTest {

	@InjectMocks
	private PlayerTransformer sut;

	@Test
	void apply() {
		final PlayerModel playerModel = createPlayerModel();
		final Player result = sut.apply(playerModel);

		assertThat(result.getCountry()).isEqualTo(playerModel.getCountry());
		assertThat(result.getId().toString()).isEqualTo(playerModel.getPlayerId());
		assertThat(result.getMyUser().getId().toString()).isEqualTo(playerModel.getUserId());
	}

	@Test
	void apply_withNoId() {
		final PlayerModel playerModel = createPlayerModelNew();
		final Player result = sut.apply(playerModel);

		assertThat(result.getCountry()).isEqualTo(playerModel.getCountry());
		assertThat(result.getId()).isNull();
		assertThat(result.getMyUser().getId().toString()).isEqualTo(playerModel.getUserId());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}
}
