package se.webinfostudio.game.etheder.api.resources.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createPlayerModel;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.player.PlayerModel;
import se.webinfostudio.game.etheder.api.resources.player.PlayerResource;
import se.webinfostudio.game.etheder.api.transformer.player.PlayerModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.player.PlayerTransformer;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.service.player.PlayerService;

/**
 *
 * @author Johan Hanson
 *
 */
public class PlayerResourceTest {

	@InjectMocks
	private PlayerResource sut;

	@Mock
	private PlayerService playerService;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		final PlayerModelTransformer playerModelTransformer = new PlayerModelTransformer();
		final PlayerTransformer playerTransformer = new PlayerTransformer();

		sut = new PlayerResource(objectMapper, playerService, playerTransformer, playerModelTransformer);
	}

	@Test
	void create() {
		final PlayerModel playerModel = createPlayerModel();
		final Player player = createPlayer();

		when(playerService.createPlayer(any(Player.class))).thenReturn(player);

		final Response response = sut.createPlayer(playerModel);

		assertThat(response.getStatus()).isEqualTo(200);
	}

}
