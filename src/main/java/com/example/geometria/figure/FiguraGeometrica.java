package com.example.geometria.figure;

import java.io.Serializable;

public abstract class FiguraGeometrica extends Object implements Misurabile, Serializable {

	private static final long serialVersionUID = 1L;

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
