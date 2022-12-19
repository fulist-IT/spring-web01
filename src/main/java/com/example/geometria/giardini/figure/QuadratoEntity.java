package com.example.geometria.giardini.figure;

import com.example.geometria.figure.Quadrato;

public class QuadratoEntity extends FiguraGeometricaEntity {
	private static final long serialVersionUID = 1L;

	private double lato;

	public QuadratoEntity(Quadrato quadrato) {
		super();
		this.lato = quadrato.getLato();
	}

	public double getLato() {
		return lato;
	}

	public void setLato(double lato) {
		this.lato = lato;
	}
}
