package se.webinfostudio.game.etheder.entity.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import se.webinfostudio.game.etheder.entity.core.UnitType;

/**
 * http://nurkiewicz.blogspot.se/2013/06/mapping-enums-done-right-with-convert.html
 *
 * @author Johan Hanson
 */
@Converter(autoApply = true)
public class UnitTypeConverter implements AttributeConverter<UnitType, String> {

	@Override
	public String convertToDatabaseColumn(final UnitType attribute) {
		return attribute.getLabel();
	}

	@Override
	public UnitType convertToEntityAttribute(final String dbData) {
		switch (dbData) {
		case "I":
			return UnitType.INFANTRY;
		case "C":
			return UnitType.CAVALRY;
		case "A":
			return UnitType.ARCHER;
		case "S":
			return UnitType.SIEGE;
		case "H":
			return UnitType.HERO;
		case "M":
			return UnitType.MONSTER;
		case "T":
			return UnitType.TRANSPORT;
		case "NS":
			return UnitType.NOT_SPCIFIED;
		default:
			throw new IllegalArgumentException("Not available dbData");
		}
	}

}
