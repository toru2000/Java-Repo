package com.jdc.toru.entity.converters;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String>{

	@Override
	public String convertToDatabaseColumn(Color c) {
		return "%s,%s,%s,%s".formatted(c.getRed(),c.getGreen(),c.getBlue(),c.getAlpha());
	}

	@Override
	public Color convertToEntityAttribute(String str) {
		
		if(null != str) {
			var array = str.split(",");
			return new Color(getColorCode(array[0]),
					getColorCode(array[1]),
					getColorCode(array[2]),
					getColorCode(array[3]));
			
		}
		return null;
	}

	private float getColorCode(String string) {
		var factor = new BigDecimal(255);
		var color = new BigDecimal(string);
		
		return color.divide(factor,12,RoundingMode.HALF_UP).floatValue();
	}

}
