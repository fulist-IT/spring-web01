package com.example.geometria.giardini;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.geometria.figure.FiguraGeometrica;

public class PreventivoNoArray {

	private int contoPosizione = 0;
	private BigDecimal costoPrato = new BigDecimal(5);
	private BigDecimal costoSiepe = new BigDecimal(20);

	private BigDecimal totaleSiepe = BigDecimal.ZERO;
	private BigDecimal totalePrato = BigDecimal.ZERO;

	public void add(FiguraGeometrica f, int valorizzaSiepe, int valorizzaPrato) {
		if (f == null) {
			return;
		}

		totaleSiepe = totaleSiepe.add(costoSiepe.multiply(new BigDecimal(f.perimetro()).multiply(new BigDecimal(valorizzaSiepe))));
		totalePrato = totalePrato.add(costoPrato.multiply(new BigDecimal(f.area()).multiply(new BigDecimal(valorizzaPrato))));
		contoPosizione++;
	}

	/**
	 * aggiunge una figura al preventivo
	 * 
	 * @param f la figura
	 */
	public void add(FiguraGeometrica f) {
		add(f, 1, 1);
	}

	/**
	 * calcola il numero degli elementi presenti
	 * 
	 * @return il numero degli elementi presenti
	 */
	public int count() {
		return contoPosizione;
	}

	/**
	 * calcola il preventivo relativo alla siepe
	 * 
	 * @return il valore del preventivo
	 */
	public BigDecimal siepe() {
		return totaleSiepe.setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * calcola il preventivo relativo al prato
	 * 
	 * @return il valore del preventivo
	 */
	public BigDecimal prato() {
		return totalePrato.setScale(2, RoundingMode.HALF_UP);
	}
}
