package com.example.geometria.figure;

public class FiguraIrregolare extends FiguraGeometrica {

	private double area;
	private double perimetro;

	public FiguraIrregolare(double area, double perimetro) {
		super();
		this.area = area;
		this.perimetro = perimetro;
	}

	@Override
	public double area() {
		return area;
	}

	@Override
	public double perimetro() {
		return perimetro;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FiguraIrregolare [perimetro=").append(perimetro).append(", area=").append(area).append("]");
		return builder.toString();
	}

}
