package com.example.geometria.giardini;

import static com.example.serialization.Serializzatore.*;

import java.io.Serializable;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.geometria.figure.Misurabile;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GeometriaSerializationConverter implements AttributeConverter<Misurabile, String> {
	private Logger log = LogManager.getLogger(this.getClass());

	@Override
	public String convertToDatabaseColumn(Misurabile object) {
		return serializeToString((Serializable) object);
	}

	@Override
	public Misurabile convertToEntityAttribute(String dbData) {
		return deSerialize(dbData, Misurabile.class);
	}



}