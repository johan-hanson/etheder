package se.webinfostudio.game.etheder.entity.converters;

import se.webinfostudio.game.etheder.entity.player.CityLevel;

/**
 *
 * @author Johan Hanson
 */
public class CityLevelConverter /* implements AttributeConverter<CityLevel, Integer> */ {

	public Integer convertToDatabaseColumn(final CityLevel attribute) {
		return attribute.getLevel();
	}

	public CityLevel convertToEntityAttribute(final Integer dbData) {
		return CityLevel.valueOf("LEVEL" + dbData);
	}

}
