package com.example.geometria.giardini;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.database.entity.CerchioEntity;
import com.example.database.entity.EllisseEntity;
import com.example.database.entity.FiguraGeometricaEntity;
import com.example.database.entity.FiguraIrregolareEntity;
import com.example.database.entity.QuadratoEntity;
import com.example.database.entity.RettangoloEntity;
import com.example.database.entity.TriangoloEntity;
import com.example.geometria.figure.Cerchio;
import com.example.geometria.figure.Ellisse;
import com.example.geometria.figure.Misurabile;
import com.example.geometria.figure.Quadrato;
import com.example.geometria.figure.Rettangolo;
import com.example.geometria.figure.Triangolo;

import jakarta.persistence.AttributeConverter;
// non necessita di notazione @Converter perché lo utilizziamo noi manualmente
public class GeometriaMisurabileToEntityConverter implements AttributeConverter<Misurabile, FiguraGeometricaEntity> {
	private Logger log = LogManager.getLogger(this.getClass());

	@Override
	public FiguraGeometricaEntity convertToDatabaseColumn(Misurabile object) {
		String objectClass = object.getClass().getSimpleName().toLowerCase();
		return switch (objectClass) {
			case "cerchio" -> {
				Cerchio o = (Cerchio) object;
				yield new CerchioEntity(o);
			}
			case "ellisse" -> {
				Ellisse o = (Ellisse) object;
				yield new EllisseEntity(o);
			}
			case "quadrato" -> {
				Quadrato o = (Quadrato) object;
				yield new QuadratoEntity(o);
			}
			case "rettangolo" -> {
				Rettangolo o = (Rettangolo) object;
				yield new RettangoloEntity(o);
			}
			case "triangolo" -> {
				Triangolo o = (Triangolo) object;
				yield new TriangoloEntity(o);
			}
			default -> {
				yield new FiguraIrregolareEntity(object);
			}
		};
	}

	@Override
	public Misurabile convertToEntityAttribute(FiguraGeometricaEntity entity) {
			return entity.toFiguraGeometrica();
		};

}