package se.webinfostudio.game.etheder.entity.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import se.webinfostudio.game.etheder.entity.player.CityLevel;

/**
 *
 * @author Johan Hanson
 */
@Converter
public class CityLevelConverter implements AttributeConverter<CityLevel, Integer> {

	@Override
	public Integer convertToDatabaseColumn(final CityLevel attribute) {
		return attribute.getLevel();
	}

	@Override
	public CityLevel convertToEntityAttribute(final Integer dbData) {
		return CityLevel.valueOf("LEVEL" + dbData);
	}

}
