package com.example.geometria.figure;

import java.util.Random;

public class TestGeneratoreDiFigure {

	public static void main(String[] args) {

		Random random = new Random();
		
		GeneratoreDiFigure gen = new GeneratoreDiFigure();
		
		for(int i=0;i<5;i++) {
			
			FiguraGeometrica fg = gen.genera(random.nextInt(5)+1);
			
			System.out.println(fg);
		}
	}
}
