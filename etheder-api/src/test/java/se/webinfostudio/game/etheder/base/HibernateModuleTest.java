package se.webinfostudio.game.etheder.base;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import se.webinfostudio.game.etheder.ApiConfiguration;

/**
 *
 * @author Johan Hanson
 *
 */
public class HibernateModuleTest {

	@InjectMocks
	private HibernateModule sut;

	@Mock
	private Bootstrap<ApiConfiguration> bootstrap;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	void hibernateModule() {
		final HibernateModule result = HibernateModule.hibernateModule(bootstrap);

		assertThat(result).isNotNull();

		verify(bootstrap, times(2)).addBundle(any(HibernateBundle.class));
	}
}
