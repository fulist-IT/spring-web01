package com.example.geometria.figure;

import java.util.Objects;

public class Ellisse extends FiguraGeometrica {
	private double semiasseMinore;
	private double semiasseMaggiore;

	public Ellisse(double semiasseMinore, double semiasseMaggiore) {
		super();
		this.semiasseMinore = semiasseMinore;
		this.semiasseMaggiore = semiasseMaggiore;
	}

	@Override
	public double area() {
		return Math.PI * semiasseMinore * semiasseMaggiore;
	}

	@Override
	public double perimetro() {
		return 2 * Math.PI * Math.sqrt( (Math.pow(semiasseMinore, 2) + Math.pow(semiasseMaggiore, 2) ) / 2);
	}

	public double getSemiasseMinore() {
		return semiasseMinore;
	}

	public double getSemiasseMaggiore() {
		return semiasseMaggiore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ellisse [semiasseMinore=").append(semiasseMinore).append(", semiasseMaggiore=")
				.append(semiasseMaggiore).append(", perimetro()=").append(perimetro()).append(", area()=")
				.append(area()).append("]");
		return builder.toString();
	}


}
