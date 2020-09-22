package se.webinfostudio.game.etheder.api.resources.player;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createPlayerModel;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.player.PlayerModel;
import se.webinfostudio.game.etheder.api.transformer.player.PlayerModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.player.PlayerTransformer;
import se.webinfostudio.game.etheder.domain.auth.AuthUser;
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

	@Mock
	private AuthUser user;

	private final UUID userId = randomUUID();

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		final PlayerModelTransformer playerModelTransformer = new PlayerModelTransformer();
		final PlayerTransformer playerTransformer = new PlayerTransformer();

		when(user.getUserIdAsUUID()).thenReturn(userId);

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

	@Test
	void getPlayer() {
		final Player player = createPlayer();
		final UUID playerId = randomUUID();

		when(playerService.getPlayer(playerId, userId)).thenReturn(player);

		final Response response = sut.getPlayer(playerId.toString(), user);

		assertThat(response.getStatus()).isEqualTo(200);
	}

}
