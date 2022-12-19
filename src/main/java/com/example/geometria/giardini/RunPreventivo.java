package com.example.geometria.giardini;

import com.example.geometria.figure.Cerchio;
import com.example.geometria.figure.Quadrato;
import com.example.geometria.figure.Rettangolo;
import static com.example.geometria.giardini.Regole.*;

public class RunPreventivo {

	public static void main(String[] args) {
		Preventivo preventivo = new Preventivo("Attilio","Infame","casa Sua", "cellulare");

		// 2 rettangoli 20x3
		for(int i=0; i<2; i++) {
			preventivo.add( new Rettangolo(20, 3), SI, NO );
		}

		// 6 quadrati di lato 4
		Quadrato q = new Quadrato(4);
		for(int i=0; i<6; i++) {
//			preventivo.add( new Quadrato(4) );
			preventivo.add( q );
		}

// punto di attenzione, dove ci porta?
//		Zona z = new Zona(q, 1, 1);
//		Zona z1 = new Zona(z, 1, 1);
//		Zona z2 = new Zona(z1, 1, 1);
//		preventivo.add( z2 );

		// 1 cerchio di raggio 2,5
		//preventivo.add( new Cerchio(2.5) );

		preventivo.add(new Cerchio(2.5)).withArea(NO);

		String report = String.format("Numero aiuole=%s - Costo Prato=%s - Costo Siepe=%s", preventivo.count(), preventivo.prato(), preventivo.siepe());
		System.out.println(report);

		//preventivo.add(new Zona(28.0, 35.0).withArea(NO).withPerimetro(NO));
	}

}