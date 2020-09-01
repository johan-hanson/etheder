package se.webinfostudio.game.etheder.entity.converters;

import java.util.UUID;

/**
 *
 * @author Johan Hanson
 *
 */
public class UuidConverter /* implements AttributeConverter<UUID, UUID> */ {

	public UUID convertToDatabaseColumn(final UUID attribute) {
		return attribute;
	}

	public UUID convertToEntityAttribute(final UUID dbData) {
		return dbData;
	}

}
