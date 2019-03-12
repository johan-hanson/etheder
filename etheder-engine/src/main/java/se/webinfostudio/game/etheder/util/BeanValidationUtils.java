package se.webinfostudio.game.etheder.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Johan Hanson
 *
 */
public final class BeanValidationUtils {

	private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

	public static <E> void validate(final E entity) {
		final Set<ConstraintViolation<E>> violations = VALIDATOR.validate(entity);

		if (violations.isEmpty()) {
			return;
		}

		throw new ConstraintViolationException(violations);
	}

	private BeanValidationUtils() {
		// not used
	}

}
