package se.webinfostudio.game.etheder.service.player;

import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createPlayer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.dao.player.PlayerDAO;
import se.webinfostudio.game.etheder.entity.player.Player;

/**
 *
 * @author Johan Hanson
 */
public class PlayerServiceTest {

	@Mock
	private PlayerDAO playerDAO;

	@InjectMocks
	private PlayerService sut;

	@Test
	public void create() {
		final Player player = createPlayer();
		player.setCountry("La grande");
		sut.createPlayer(player);
	}

	@Test
	public void findById() {
//        final Player p = ethederTestFactory.createPlayer();
//        when(playerRepository.findById(Matchers.anyLong())).thenReturn(p);
//        final Player p2 = sut.findById(p.getId());
//        Assert.assertEquals(p.getId(), p2.getId());
	}

	@Before
	public void setUp() {
		sut = new PlayerService();
		initMocks(this);
	}
}
