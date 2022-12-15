package com.example.geometria.figure;

public class Cerchio extends Ellisse{
	
	private double raggio;

	public Cerchio(double raggio) {
		super(raggio, raggio);
		this.raggio = raggio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cerchio [raggio=").append(raggio).append(", area()=").append(area()).append(", perimetro()=")
				.append(perimetro()).append("]");
		return builder.toString();
	}
}
