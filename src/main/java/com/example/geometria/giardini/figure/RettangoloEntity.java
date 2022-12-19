package com.example.geometria.giardini.figure;

import com.example.geometria.figure.Rettangolo;

public class RettangoloEntity extends FiguraGeometricaEntity {
	private static final long serialVersionUID = 1L;

	private double base;
	private double altezza;

	public RettangoloEntity(Rettangolo rettangolo) {
		super();
		this.base = rettangolo.getBase();
		this.altezza = rettangolo.getAltezza();
	}

	public double getBase() {
		return base;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}




}
