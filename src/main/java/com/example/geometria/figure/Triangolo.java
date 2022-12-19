package com.example.geometria.figure;

import java.awt.geom.Point2D;

public class Triangolo extends FiguraGeometrica {

	private double latoA;
	private double latoB;
	private double latoC;

	/**
	 * Modifiche di Francesco il 23/11/22 controllo validita chiusura triangolo
	 * Da terminare a cura di Graziano
	 */
	public Triangolo(double latoA, double latoB, double latoC) {
		super();
		if(canTriangolo()) {
		this.latoA = latoA;
		this.latoB = latoB;
		this.latoC = latoC;
		}
		else {
			System.out.println("non è stato possibile generare un triangolo genero una figura geometrica generica");
		}
	}

	private Boolean canTriangolo() {
		if(latoA+latoB-latoC<0||latoB+latoC-latoA<0||latoC+latoA-latoB<0) {
		return false;
		}
		return true;
	}

	public double getLatoA() {
		return latoA;
	}

	public double getLatoB() {
		return latoB;
	}

	public double getLatoC() {
		return latoC;
	}

	public Triangolo(Point2D p1, Point2D p2, Point2D p3) {
		this(p1.distance(p2), p1.distance(p3), p2.distance(p3));
	}

	@Override
	public double perimetro() {
		return latoA + latoB + latoC;
	}

	private double semiPerimetro() {
		return perimetro() / 2;
	}

	@Override
	public double area() {
		// formula di Erone
		// https://www.youmath.it/formulari/formulari-di-geometria-piana/406-tutte-le-formule-sul-triangolo-qualsiasi.html
		final double p = semiPerimetro();
		return Math.sqrt(p*(p-latoA)*(p-latoB)*(p-latoC));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Triangolo [latoA=").append(latoA).append(", latoB=").append(latoB).append(", latoC=")
				.append(latoC).append(", perimetro()=").append(perimetro()).append(", area()=").append(area())
				.append("]");
		return builder.toString();
	}
}
