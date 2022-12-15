package com.example.geometria.giardini;

import com.example.geometria.figure.Cerchio;
import com.example.geometria.figure.Quadrato;
import com.example.geometria.figure.Rettangolo;

public class RunPreventivo_V2 {

	public static void main(String[] args) {
		Preventivo_V2 preventivo = new Preventivo_V2(); // QUI IL CAMBIO PREVENTIVO

		// eseguire le opportune operazioni

		// 2 rettangoli 20x3
		for (int i = 0; i < 2; i++) {
			preventivo.add(new Rettangolo(20, 3), 1, 0);
		}

		// 6 quadrati di lato 4
		for (int i = 0; i < 6; i++) {
			preventivo.add(new Quadrato(4));
		}

		// 1 cerchio di raggio 2,5
		preventivo.add(new Cerchio(2.5), 1, 0);

		String report =String.format("Numero giardini: %s - Costo siepe: %s - Costo prato: %s", preventivo.count(),preventivo.siepe(),preventivo.prato());
		System.out.println(report);
	}

}