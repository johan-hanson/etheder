package se.webinfostudio.game.etheder.api.resources.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;
import static se.webinfostudio.game.etheder.util.ModelTestFactory.createUserModel;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;

import se.webinfostudio.game.etheder.api.model.user.UserModel;
import se.webinfostudio.game.etheder.api.resources.player.UserResource;
import se.webinfostudio.game.etheder.api.transformer.user.UserModelTransformer;
import se.webinfostudio.game.etheder.api.transformer.user.UserTransformer;
import se.webinfostudio.game.etheder.entity.player.User;
import se.webinfostudio.game.etheder.service.player.UserService;

/**
 *
 * @author Johan Hanson
 *
 */
public class UserResourceTest {

	@InjectMocks
	private UserResource sut;

	@Mock
	private UserService userService;
	@Mock
	private ObjectMapper objectMapper;

	@BeforeEach
	void beforeEach() {
		initMocks(this);
		final UserModelTransformer userModelTransformer = new UserModelTransformer();
		final UserTransformer userTransformer = new UserTransformer();

		sut = new UserResource(objectMapper, userService, userTransformer, userModelTransformer);
	}

	@Test
	void changePassword() {
		final Response response = sut.changePassword("old", "new");

		assertThat(response.getStatus()).isEqualTo(200);
	}

	@Test
	void create() {
		final UserModel userModel = createUserModel();
		final User user = createUser();

		when(userService.createUser(any(User.class))).thenReturn(user);

		final Response response = sut.create(userModel);

		assertThat(response.getStatus()).isEqualTo(200);
	}

	@Test
	void update() {
		final UserModel userModel = createUserModel();
		final User user = createUser();

		when(userService.updateUser(any(User.class))).thenReturn(user);

		final Response response = sut.update(userModel);

		assertThat(response.getStatus()).isEqualTo(200);
	}
}
