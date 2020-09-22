package se.webinfostudio.game.etheder.service.player;

import static java.util.UUID.randomUUID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createCity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import se.webinfostudio.game.etheder.entity.player.City;
import se.webinfostudio.game.etheder.entity.player.CityRef;
import se.webinfostudio.game.etheder.entity.util.EntityTestFactory;
import se.webinfostudio.game.etheder.repository.player.CityRepository;

/**
 *
 * @author Johan Hanson <johan@webinfostudio.se>
 */
public class CityServiceTest {

	@InjectMocks
	private CityService sut;

	@Mock
	private CityRepository cityRepository;

	@Nested
	class cityExistInList {

		@Test
		void existInList() {
			final UUID id = randomUUID();
			final Set<CityRef> cityList = new HashSet<>();
			cityList.add(createCity(randomUUID(), "Paris").toRef());
			cityList.add(createCity(id, "London").toRef());
			assertTrue(sut.cityExistInList(cityList, new CityRef(id)));
		}

		@Test
		void cityNotInList() {
			final Set<CityRef> cityList = new HashSet<>();
			cityList.add(createCity(randomUUID(), "Paris").toRef());
			cityList.add(createCity(randomUUID(), "London").toRef());
			assertFalse(sut.cityExistInList(cityList, new CityRef(randomUUID())));
		}
	}

	@Nested
	class createCity {

		@Test
		void happyflow() {
			final City city = EntityTestFactory.createCity();

			sut.createCity(city);

			verify(cityRepository).create(city);
		}
	}

	@BeforeEach
	void setUp() {
		initMocks(this);
	}

}
