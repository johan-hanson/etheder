package se.webinfostudio.game.etheder.api.transformer.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.player.PlayerModel;
import se.webinfostudio.game.etheder.api.transformer.player.PlayerModelTransformer;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerModelTransformerTest {

	@InjectMocks
	private PlayerModelTransformer sut;

	@Test
	void apply() {
		final Player player = createPlayer();
		final PlayerModel result = sut.apply(player);

		assertThat(result.getPlayerId()).isEqualTo(player.getId().toString());
		assertThat(result.getUserId()).isEqualTo(player.getMyUser().getId().toString());
		assertThat(result.getCountry()).isEqualTo(player.getCountry());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}

}
