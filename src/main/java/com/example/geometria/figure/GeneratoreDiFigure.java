package com.example.geometria.figure;

import java.util.Random;

public class GeneratoreDiFigure {

	private Random random = new Random();
	
	public FiguraGeometrica genera() {
		int tf = random.nextInt(5)+1;
		return genera(tf);
	}

	public FiguraGeometrica genera(int tipoFigura) {

		FiguraGeometrica fg = null;

		switch(tipoFigura) {
			case 1:
				fg = new Quadrato(generaDimensione());
				break;
			case 2:
				fg = new Rettangolo(generaDimensione(), generaDimensione());
				break;
			case 3:
				fg = new Cerchio(generaDimensione());
				break;
			case 4:
				fg = new Ellisse(generaDimensione(), generaDimensione());
				break;
			case 5:
				fg = new Triangolo(generaDimensione(), generaDimensione(), generaDimensione());
				break;
			default:
				int tf = random.nextInt(5)+1;
				fg = genera(tf);
				break;
		}

		return fg;
	}


	private int generaDimensione() {
		return random.nextInt(50)+1;
	}
}