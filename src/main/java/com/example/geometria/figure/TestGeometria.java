package com.example.geometria.figure;

public class TestGeometria {

	public static void main(String[] args) {
		Cerchio c = new Cerchio(100);
		System.out.println( String.format("Cerchio: area=%g perimetro=%g", c.area(), c.perimetro()));

		Rettangolo r = new Rettangolo(10, 5);
		System.out.println( String.format("Rettangolo: area=%g perimetro=%g", r.area(), r.perimetro()));

		Quadrato q = new Quadrato(10);
		Object o = q;
		FiguraGeometrica fg = q;
		Rettangolo r1 = q;

		Quadrato q1 = (Quadrato)fg; // downcasting

		System.out.println( String.format("Quadrato: area=%g perimetro=%g", q.area(), q.perimetro()));

		Ellisse e = new Ellisse(10, 5);
		System.out.println( String.format("Ellisse: area=%g perimetro=%g", e.area(), e.perimetro()));

		Triangolo t = new Triangolo(10, 10, 10);
		System.out.println( String.format("Triangolo: area=%g perimetro=%g", t.area(), t.perimetro()));


		// upcasting
		FiguraGeometrica fg1 = new Quadrato(100);

		// downcasting
		Quadrato q2 = (Quadrato) fg1;
	}
}
