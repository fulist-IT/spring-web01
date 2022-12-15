package com.example.geometria.giardini;

import com.example.geometria.figure.FiguraGeometrica;
import com.example.geometria.figure.FiguraIrregolare;
import com.example.geometria.figure.Misurabile;

public class Zona_V0 implements Misurabile{
	private FiguraGeometrica figura;

	private int flagPerimetro;
	private int flagArea;
	//private boolean flagEliminaArea;
	//private boolean flagEliminaPerimetro;

	public Zona_V0(FiguraGeometrica figura) { // da completare
		super();
		this.figura = figura;
	}

	public Zona_V0(double area, double perimetro) { // da completare
		this( new FiguraIrregolare(area, perimetro) );
	}

	// da completare con calcolo esclusioni
	public double area() {
		return figura.area(); // by delegation
	}

	// da completare con calcolo esclusioni
	public double perimetro() {
		return figura.perimetro(); // by delegation
	}
}