package com.example.database.entity;

import com.example.geometria.figure.FiguraGeometrica;
import com.example.geometria.figure.FiguraIrregolare;
import com.example.geometria.figure.Misurabile;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( value="irregolare" )
public class FiguraIrregolareEntity extends FiguraGeometricaEntity {

	private static final long serialVersionUID = 1L;
	private double area;
	private double perimetro;

	public FiguraIrregolareEntity() {
		super();
	}

	public FiguraIrregolareEntity(Misurabile misurabile) {
		super();
		this.area = misurabile.area();
		this.perimetro = misurabile.perimetro();
	}

	double getArea() {
		return area;
	}

	void setArea(double area) {
		this.area = area;
	}

	double getPerimetro() {
		return perimetro;
	}

	void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}

	@Override
	public FiguraGeometrica toFiguraGeometrica() {
		return new FiguraIrregolare(area, perimetro);
	}

}
