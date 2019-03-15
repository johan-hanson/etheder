package se.webinfostudio.game.etheder.api.player.transformer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.api.transformer.user.UserModelTransformer;
import se.webinfostudio.game.etheder.entity.player.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserModelTransformerTest {

	@InjectMocks
	private UserModelTransformer sut;

	@Test
	void apply() {
		final User user = createUser();
		final UserModel result = sut.apply(user);

		assertThat(result.getAge()).isEqualTo(user.getAge());
		assertThat(result.getCountry()).isEqualTo(user.getCountry());
		assertThat(result.getEmail()).isEqualTo(user.getEmail());
		assertThat(result.getFirstName()).isEqualTo(user.getFirstName());
		assertThat(result.getLastName()).isEqualTo(user.getLastName());
		assertThat(result.getUserId()).isEqualTo(user.getId().toString());
		assertThat(result.getUserName()).isEqualTo(user.getLogin().getUserName());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}

}
