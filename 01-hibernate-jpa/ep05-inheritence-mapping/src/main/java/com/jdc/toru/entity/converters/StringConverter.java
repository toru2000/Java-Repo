package com.jdc.toru.entity.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringConverter implements AttributeConverter<String, Integer>{ //java ka String, db ka char array

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		return Integer.parseInt(attribute);
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		return dbData.toString();
	}  

}
