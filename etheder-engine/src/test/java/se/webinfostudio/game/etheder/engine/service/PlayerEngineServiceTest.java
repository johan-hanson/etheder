package se.webinfostudio.game.etheder.engine.service;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.Player;
import se.webinfostudio.game.etheder.repository.player.CityRepository;
import se.webinfostudio.game.etheder.repository.player.PlayerRepository;

public class PlayerEngineServiceTest {

	@InjectMocks
	private PlayerEngineService sut;

	@Mock
	private CityRepository cityRepository;

	@Mock
	private PlayerRepository playerRepository;

	@BeforeEach
	protected void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	void updateResources() {
		final Player player1 = createPlayer();
		final Player player2 = createPlayer();
		final Player player3 = createPlayer();

		final City city1 = createCity();
		final City city2 = createCity();
		final City city3 = createCity();

		when(playerRepository.findAll()).thenReturn(asList(player1, player2, player3));
		when(cityRepository.findAllByPlayerId(any(UUID.class))).thenReturn(asList(city1, city2, city3));

		sut.updateResources();

		verify(playerRepository, times(3)).update(any(Player.class));
	}

}
