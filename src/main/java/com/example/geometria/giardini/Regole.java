package com.example.geometria.giardini;

import java.util.function.Function;

public enum Regole implements Function<Double, Double> {
	ADD(x -> x),  // Se fosse una classe si farebbe così: Regole ADD= new Regole (x->x);
	SUBTRACT(x -> -x),
	ZERO(x -> 0.0),
	SI(ADD),
	NO(ZERO),
	DOUBLE(x -> x*2);

	private Function<Double, Double>funzioneInterna;

	private Regole(Function<Double, Double> funzioneInterna) {
		this.funzioneInterna = funzioneInterna;
	}

	@Override
	public Double apply(Double t) {

		return this.funzioneInterna.apply(t);
	}


}
