package com.example.geometria.giardini;

import java.util.function.Function;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import static com.example.geometria.giardini.Regole.*;

@Converter(autoApply = false)
public class RegoleConverter_OLD implements AttributeConverter<Function<Double, Double>, String> {

	@Override
	public String convertToDatabaseColumn(Function<Double, Double> attribute) {
		if (attribute == ADD) {

			return "ADD";
		}
		if (attribute == ZERO) {

			return "ZERO";
		}
		return null;
	}

	@Override
	public Function<Double, Double> convertToEntityAttribute(String dbData) {
		if (dbData.equals("ZERO")) {

			return ZERO;
		}
		if (dbData.equals("ADD")) {

			return ADD;
		}
		return null;
	}

}
