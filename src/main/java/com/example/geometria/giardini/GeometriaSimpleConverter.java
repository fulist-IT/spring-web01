package com.example.geometria.giardini;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.geometria.figure.Cerchio;
import com.example.geometria.figure.Ellisse;
import com.example.geometria.figure.FiguraIrregolare;
import com.example.geometria.figure.Misurabile;
import com.example.geometria.figure.Quadrato;
import com.example.geometria.figure.Rettangolo;
import com.example.geometria.figure.Triangolo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class GeometriaSimpleConverter implements AttributeConverter<Misurabile, String> {
	private Logger log = LogManager.getLogger(this.getClass());

	@Override
	public String convertToDatabaseColumn(Misurabile object) {
		String objectClass = object.getClass().getSimpleName().toLowerCase();
		return switch (objectClass) {
		case "cerchio" -> {
			Cerchio o = (Cerchio) object;
			yield String.format("cerchio/raggio=%s", o.getRaggio());
		}
		case "ellisse" -> {
			Ellisse o = (Ellisse) object;
			yield String.format("ellisse/semiasse-minore=%s/semiasse-maggiore=%s", o.getSemiasseMinore(),
					o.getSemiasseMaggiore());
		}
		case "quadrato" -> {
			Quadrato o = (Quadrato) object;
			yield String.format("quadrato/lato=%s", o.getLato());
		}
		case "rettangolo" -> {
			Rettangolo o = (Rettangolo) object;
			yield String.format("rettangolo/base=%s/altezza=%s", o.getBase(), o.getAltezza());
		}
		case "triangolo" -> {
			Triangolo o = (Triangolo) object;
			yield String.format("triangolo/lato-a=%s/lato-b=%s/lato-c=%s", o.getLatoA(), o.getLatoB(), o.getLatoC());
		}
		default -> {
			yield String.format("irregolare/area=%s/perimetro=%s", object.area(), object.perimetro());
		}
		};
	}

	@Override
	public Misurabile convertToEntityAttribute(String dbData) {
		String[] items = dbData.split("/");
		String figura = items[0];
		Double par1 = Double.valueOf(items[1].split("=")[1]);
		/****
		IIF immediate if ==>  (CONDIZIONE BOOLEANA) ? <valore per vero> : <valore per falso>
		equivalente di:
		Double par2 = 0.0;
		if(items.length > 2) {
			par2 = Double.valueOf(items[2].split("=")[1]);
		} else {
			par2 = 0.0;
		}
		****/
		Double par2 = (items.length > 2) ? Double.valueOf(items[2].split("=")[1]) : 0.0;
		Double par3 = (items.length > 3) ? Double.valueOf(items[3].split("=")[1]) : 0.0;

		return switch (figura) {
		case "cerchio" -> new Cerchio(par1);
		case "quadrato" -> new Quadrato(par1);
		case "ellisse" -> new Ellisse(par1, par2);
		case "rettangolo" -> new Rettangolo(par1, par2);
		case "triangolo" -> new Triangolo(par1, par2, par3);
		default -> new FiguraIrregolare(par1, par2);
		};

//		return null;
	}

}