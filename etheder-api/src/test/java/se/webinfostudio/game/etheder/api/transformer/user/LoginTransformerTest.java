package se.webinfostudio.game.etheder.api.transformer.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createLoginModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import se.webinfostudio.game.etheder.api.model.user.LoginModel;
import se.webinfostudio.game.etheder.entity.user.Login;

public class LoginTransformerTest {

	@InjectMocks
	private LoginTransformer sut;

	@Test
	void apply() {
		final LoginModel loginModel = createLoginModel();
		final Login result = sut.apply(loginModel);

		assertThat(result.getUserName()).isEqualTo(loginModel.getUserName());
		assertThat(result.getPasswordHash()).isEqualTo(loginModel.getPassword());
	}

	@BeforeEach
	void setup() {
		initMocks(this);
	}
}
