package se.webinfostudio.game.etheder.api.transformer;

import static java.util.UUID.fromString;

import java.util.UUID;

public final class TransformerHelper {

	public static UUID createUUIDFromString(final String id) {
		return id == null ? null : fromString(id);
	}

	private TransformerHelper() {
		// not used
	}
}
