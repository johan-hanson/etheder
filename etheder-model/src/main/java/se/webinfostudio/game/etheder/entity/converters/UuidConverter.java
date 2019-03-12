package se.webinfostudio.game.etheder.entity.converters;

import java.util.UUID;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Johan Hanson
 *
 */
@Converter(autoApply = true)
public class UuidConverter implements AttributeConverter<UUID, UUID> {

	@Override
	public UUID convertToDatabaseColumn(final UUID attribute) {
		return attribute;
	}

	@Override
	public UUID convertToEntityAttribute(final UUID dbData) {
		return dbData;
	}

}
