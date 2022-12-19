package com.example.geometria.figure;

public class Quadrato extends Rettangolo {
	private final double lato;

	public Quadrato(double lato) {
		super(lato, lato);
		this.lato = lato;
	}

	public double getLato() {
		return lato;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Quadrato [lato=").append(lato).append(", area()=").append(area()).append(", perimetro()=")
				.append(perimetro()).append("]");
		return builder.toString();
	}


}
