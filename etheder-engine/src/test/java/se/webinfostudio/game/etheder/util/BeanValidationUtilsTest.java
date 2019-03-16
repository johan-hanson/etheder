package se.webinfostudio.game.etheder.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static se.webinfostudio.game.etheder.entity.util.EntityTestFactory.createUser;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.webinfostudio.game.etheder.entity.user.User;

public class BeanValidationUtilsTest {

	private User user;

	@BeforeEach
	void beforeEach() {
		user = createUser();
	}

	@Test
	void validate() {
		BeanValidationUtils.validate(user);
	}

	@Test
	void validate_shouldThrowExcpetion_whenConstraintValidation() {
		user.setFirstName(null);
		assertThatThrownBy(() -> BeanValidationUtils.validate(user))
				.isInstanceOf(ConstraintViolationException.class);
	}
}
