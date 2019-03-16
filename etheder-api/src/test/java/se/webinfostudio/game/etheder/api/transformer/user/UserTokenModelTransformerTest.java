package se.webinfostudio.game.etheder.api.transformer.user;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.user.UserTokenModel;
import se.webinfostudio.game.etheder.entity.user.Login;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserTokenModelTransformerTest {

	@InjectMocks
	private UserTokenModelTransformer sut;

	@Test
	void apply() {
		final Login login = createUser().getLogin();
		login.setToken(randomUUID());
		final UserTokenModel result = sut.apply(login);

		assertThat(result.getUserName()).isEqualTo(login.getUserName());
		assertThat(result.getToken()).isEqualTo(login.getToken().toString());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}

}
