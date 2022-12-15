package com.example.geometria.figure;

public abstract class FiguraGeometrica implements Misurabile{
	
	public abstract double area();
	
	public abstract double perimetro();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FiguraGeometrica [area()=").append(area()).append(", perimetro()=").append(perimetro())
				.append("]");
		return builder.toString();
	}
	
}
