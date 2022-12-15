package com.example.geometria.figure;

public class Rettangolo extends FiguraGeometrica{
	
	private double base;
	private double altezza;
	
	public Rettangolo(double base, double altezza) {
		super();
		this.base = base;
		this.altezza = altezza;
	}
	
	public double area() {
		return base*altezza;
	}
	
	public double perimetro() {
		return 2*base + 2*altezza;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rettangolo [base=").append(base).append(", altezza=").append(altezza).append("]");
		return builder.toString();
	}
}
