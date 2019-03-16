package se.webinfostudio.game.etheder.api.transformer.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createUserModel;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createUserModelNew;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.api.transformer.user.UserTransformer;
import se.webinfostudio.game.etheder.entity.user.User;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserTransformerTest {

	@InjectMocks
	private UserTransformer sut;

	@Test
	void apply() {
		final UserModel userModel = createUserModel();
		final User result = sut.apply(userModel);

		assertThat(result.getAge()).isEqualTo(userModel.getAge());
		assertThat(result.getFirstName()).isEqualTo(userModel.getFirstName());
		assertThat(result.getLastName()).isEqualTo(userModel.getLastName());
		assertThat(result.getCountry()).isEqualTo(userModel.getCountry());
		assertThat(result.getEmail()).isEqualTo(userModel.getEmail());
		assertThat(result.getId().toString()).isEqualTo(userModel.getUserId());
		assertThat(result.getLogin().getUserName()).isEqualTo(userModel.getUserName());
	}

	@Test
	void apply_withNoId() {
		final UserModel userModel = createUserModelNew();
		final User result = sut.apply(userModel);

		assertThat(result.getAge()).isEqualTo(userModel.getAge());
		assertThat(result.getFirstName()).isEqualTo(userModel.getFirstName());
		assertThat(result.getLastName()).isEqualTo(userModel.getLastName());
		assertThat(result.getCountry()).isEqualTo(userModel.getCountry());
		assertThat(result.getEmail()).isEqualTo(userModel.getEmail());
		assertThat(result.getId()).isNull();
		assertThat(result.getLogin().getUserName()).isEqualTo(userModel.getUserName());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}
}
