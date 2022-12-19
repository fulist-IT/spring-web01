package com.example.geometria.giardini;

import java.util.function.Function;

public class RegoleDemo /* extends java.lang.Enum */ implements Function<Double, Double> {

	public static final RegoleDemo ADD = new RegoleDemo(x->x);
	public static final RegoleDemo ZERO = new RegoleDemo(x->0.0);

	private Function<Double, Double> funzioneInterna;

	private RegoleDemo(Function<Double, Double> funzioneInterna) {
		this.funzioneInterna = funzioneInterna;
	}

	@Override
	public Double apply(Double t) {
		return this.funzioneInterna.apply(t);
	}
}
