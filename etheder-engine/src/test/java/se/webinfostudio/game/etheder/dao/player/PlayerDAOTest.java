package se.webinfostudio.game.etheder.dao.player;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 *
 */
@ExtendWith(DropwizardExtensionsSupport.class)
public class PlayerDAOTest {

	private PlayerDAO sut;

	@BeforeEach
	void before() {
		sut = new PlayerDAO();
	}

	void findByUserId() {
		final Player player = createPlayer();
		final UUID userId = player.getUser().getId();

		final Optional<Player> result = sut.findByUserId(userId);

		assertThat(result.isPresent()).isTrue();
		assertThat(result.get().getUser().getId()).isEqualTo(userId);
	}

	void findByUserId_shouldReturnEmpty_whenNoPlayerFound() {
		final UUID userId = randomUUID();

		final Optional<Player> result = sut.findByUserId(userId);

		assertThat(result.isPresent()).isFalse();
	}

	void persist() {
		final Player player = createPlayer();
		final Player result = sut.persist(player);

		assertThat(result.getId()).isEqualTo(player.getId());
	}

}
