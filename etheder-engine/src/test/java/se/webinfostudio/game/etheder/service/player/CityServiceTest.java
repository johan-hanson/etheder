package se.webinfostudio.game.etheder.service.player;

import static java.util.UUID.randomUUID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.webinfostudio.game.etheder.entity.player.CityRef;

/**
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
public class CityServiceTest {

	private CityService sut;

	@Test
	void cityExistInList() {
		final UUID id = randomUUID();
		final Set<CityRef> cityList = new HashSet<>();
		cityList.add(createCity(randomUUID(), "Paris").toRef());
		cityList.add(createCity(id, "London").toRef());
		assertTrue(sut.cityExistInList(cityList, new CityRef(id)));
	}

	@Test
	void cityExistInListFalse() {
		final Set<CityRef> cityList = new HashSet<>();
		cityList.add(createCity(randomUUID(), "Paris").toRef());
		cityList.add(createCity(randomUUID(), "London").toRef());
		assertFalse(sut.cityExistInList(cityList, new CityRef(randomUUID())));
	}

	@BeforeEach
	void setUp() {
		sut = new CityService(null);
	}

}
