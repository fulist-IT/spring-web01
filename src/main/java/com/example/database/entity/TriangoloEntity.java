package com.example.database.entity;

import com.example.geometria.figure.Triangolo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( value="triengolo" )
public class TriangoloEntity extends FiguraGeometricaEntity {

	private static final long serialVersionUID = 1L;
	private double latoA;
	private double latoB;
	private double latoC;

	public TriangoloEntity() {
		super();
	}

	/**
	 * Modifiche di Francesco il 23/11/22 controllo validita chiusura triangolo
	 * Da terminare a cura di Graziano
	 */
	public TriangoloEntity(Triangolo triangolo) {
		super();
		this.latoA = triangolo.getLatoA();
		this.latoB = triangolo.getLatoB();
		this.latoC = triangolo.getLatoC();
	}

	double getLatoA() {
		return latoA;
	}

	void setLatoA(double latoA) {
		this.latoA = latoA;
	}

	double getLatoB() {
		return latoB;
	}

	void setLatoB(double latoB) {
		this.latoB = latoB;
	}

	double getLatoC() {
		return latoC;
	}

	void setLatoC(double latoC) {
		this.latoC = latoC;
	}

	@Override
	public Triangolo toFiguraGeometrica() {
		return new Triangolo(latoA, latoB, latoC);
	}


}
