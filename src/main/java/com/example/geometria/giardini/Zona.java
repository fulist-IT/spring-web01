package com.example.geometria.giardini;

import java.util.function.Function;

import com.example.geometria.figure.FiguraIrregolare;
import com.example.geometria.figure.Misurabile;

public class Zona implements Misurabile {
	public static final Function<Double, Double> ADD = (x)->x; 
	public static final Function<Double, Double> SUBTRACT = (x)->-x;
	public static final Function<Double, Double> ZERO = (x)->0.0;
	public static final Function<Double, Double> SI = ADD;
	public static final Function<Double, Double> NO = ZERO;
	
	public static final Function<Double, Double> ADD2 = new Function<>() {
		public Double apply(Double t) {
			return t;
		}};
	
	
	private Misurabile figura;
	private Function<Double, Double> funzioneArea;
	private Function<Double, Double> funzionePerimetro;

	public Zona(Misurabile figura, Function<Double, Double> funzionePerimetro,  Function<Double, Double> funzioneArea) { // da completare
		super();
		this.figura = figura;
		this.funzionePerimetro = funzionePerimetro;
		this.funzioneArea=funzioneArea;
	}

	public Zona(Misurabile figura) { // da completare
		this(figura, ADD, ADD);
	}

	public Zona(Double perimetro, Double area, Function<Double, Double> funzionePerimetro, Function<Double, Double> funzioneArea) { // da completare
		this(new FiguraIrregolare(area, perimetro), funzionePerimetro, funzioneArea);
	}

	public Zona(Double perimetro, Double area) { // da completare
		this(area, perimetro, ADD, ADD);
	}

	// da completare con calcolo esclusioni
	public double area() {
		return funzioneArea.apply(figura.area()); // by delegation
	}

	// da completare con calcolo esclusioni
	public double perimetro() {
		return funzionePerimetro.apply(figura.perimetro()); // by delegation
	}
	
	public Zona withPerimetro(Function<Double, Double> f) {
		this.funzionePerimetro=f;
		return this;
	}
	
	public Zona withArea(Function<Double, Double> f) {
		this.funzioneArea=f;
		return this;
	}
//	//public void funzione(String s) {
//	//	switch(s) {
//	//	case "area": 
//	//		funzioneArea=(x)->x;
//		case "peri
//		}
//	}

}