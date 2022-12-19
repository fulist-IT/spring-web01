package com.example.geometria.figure;

import java.util.ArrayList;
import java.util.List;

public class Rettangolo extends FiguraGeometrica {
	private final double base;
	private final double altezza;

	private final List<String> strs = new ArrayList<>();

	public List<String> getStrs() {
		return strs;
	}

	public Rettangolo(double base, double altezza) {
		super();
		this.base = base;
		this.altezza = altezza;
	}

	public double getBase() {
		return base; //Double.doubleValue();
	}

	public double getAltezza() {
		return altezza;
	}

	@Override
	public double area() {
		return base * altezza;
	}

	@Override
	public double perimetro() {
		return 2 * (base + altezza);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rettangolo [base=").append(base).append(", altezza=").append(altezza).append(", area()=")
				.append(area()).append(", perimetro()=").append(perimetro()).append("]");
		return builder.toString();
	}



}
