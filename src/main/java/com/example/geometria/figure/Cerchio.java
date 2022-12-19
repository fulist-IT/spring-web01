package com.example.geometria.figure;

public class Cerchio extends Ellisse {
	private double raggio;

	public Cerchio(double raggio) {
		super(raggio, raggio);
		this.raggio = raggio;
	}

	public double circonferenza() {
		return perimetro();
	}

	public double getRaggio() {
		return raggio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cerchio [raggio=").append(raggio).append(", perimetro()=").append(perimetro())
				.append(", area()=").append(area()).append("]");
		return builder.toString();
	}
}
