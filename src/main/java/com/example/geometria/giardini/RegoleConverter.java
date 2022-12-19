package com.example.geometria.giardini;

import java.util.function.Function;
import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RegoleConverter implements AttributeConverter<Regole, String> {

	@Override
	public String convertToDatabaseColumn(Regole regola) {
		if(regola == null) {
			return null;
		}
		return regola.name();
	}

	@Override
	public Regole convertToEntityAttribute(String nomeRegola) {
		if(nomeRegola==null) {
			return null;
		}
		 return Stream.of(Regole.values())
				.filter( regola -> regola.name().equals(nomeRegola) )
				.findFirst()
//				.get();
				.orElseThrow(IllegalArgumentException::new);
	}



}
