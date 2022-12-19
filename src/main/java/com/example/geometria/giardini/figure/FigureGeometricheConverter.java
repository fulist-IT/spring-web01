package com.example.geometria.giardini.figure;

import com.example.geometria.figure.FiguraGeometrica;
import com.example.geometria.figure.Rettangolo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FigureGeometricheConverter implements AttributeConverter<FiguraGeometrica, FiguraGeometricaEntity> {

	@Override
	public FiguraGeometricaEntity convertToDatabaseColumn(FiguraGeometrica attribute) {
		if (attribute instanceof Rettangolo) {
			return new RettangoloEntity((Rettangolo) attribute);
		}
		return null;
	}

	@Override
	public FiguraGeometrica convertToEntityAttribute(FiguraGeometricaEntity dbData) {
		if (dbData instanceof RettangoloEntity) {
			RettangoloEntity re = (RettangoloEntity) dbData;
			return new Rettangolo(re.getBase(), re.getAltezza() );
		}		return null;
	}

}
