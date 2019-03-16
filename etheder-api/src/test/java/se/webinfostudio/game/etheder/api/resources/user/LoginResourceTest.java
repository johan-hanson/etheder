package se.webinfostudio.game.etheder.api.resources.user;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createLoginModel;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.user.LoginModel;
import se.webinfostudio.game.etheder.api.transformer.user.LoginTransformer;
import se.webinfostudio.game.etheder.api.transformer.user.UserTokenModelTransformer;
import se.webinfostudio.game.etheder.entity.user.Login;
import se.webinfostudio.game.etheder.service.user.LoginService;

/**
 *
 * @author Johan Hanson
 *
 */
public class LoginResourceTest {

	@InjectMocks
	private LoginResource sut;

	@Mock
	private LoginService loginService;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		final UserTokenModelTransformer userTokenModelTransformer = new UserTokenModelTransformer();
		final LoginTransformer loginTransformer = new LoginTransformer();

		sut = new LoginResource(objectMapper, loginService, loginTransformer, userTokenModelTransformer);
	}

	@Test
	void login() {
		final Login login = createUser().getLogin();
		final LoginModel loginModel = createLoginModel();

		when(loginService.login(any(Login.class))).thenReturn(of(login));

		final Response response = sut.login(loginModel);

		assertThat(response.getStatus()).isEqualTo(200);
	}

}
