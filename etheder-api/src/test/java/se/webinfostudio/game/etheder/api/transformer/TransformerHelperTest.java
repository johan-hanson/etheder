package se.webinfostudio.game.etheder.api.transformer;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class TransformerHelperTest {

	@Test
	void createUUIDFromString() {
		final UUID expected = randomUUID();
		final UUID result = TransformerHelper.createUUIDFromString(expected.toString());
		assertThat(result).isEqualTo(expected);
	}

	@Test
	void createUUIDFromStringNull() {
		final UUID result = TransformerHelper.createUUIDFromString(null);
		assertThat(result).isNull();
	}
}
