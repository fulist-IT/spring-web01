package com.example.geometria.giardini;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.geometria.figure.Misurabile;

public class Preventivo_V2 {

	private static final Logger log = LogManager.getLogger(Preventivo_V2.class);

	private List<Misurabile> figure = new ArrayList<>();
	private List<Integer> infoPrati = new ArrayList<>();
	private List<Integer> infoSiepi = new ArrayList<>();

	private BigDecimal costoPrato = new BigDecimal(5);
	private BigDecimal costoSiepe = new BigDecimal(20);

	public Preventivo_V2() {
		super();
		log.info("Costruttore preventivo");
	}

	/**
	 * aggiunge una figura al preventivo
	 *
	 * @param f la figura
	 */
	public void add(Misurabile f) {
		log.trace("passato da add(misurabile f) {}",f); //trace
		add(f, 1, 1);
	}

	// Overloading nel caso il cliente faccia richieste più specifiche (cioè
	// specifichi che vuole solo o prato o siepe)
	public void add(Misurabile f, int valorizzaSiepe, int valorizzaPrato) { // 0=non aggiungere, 1=aggiungere
		log.trace("passato da add(misurabile f) {}",f);
		if (f == null) {
			return;
		}
		figure.add(f);
		infoSiepi.add(valorizzaSiepe);
		infoPrati.add(valorizzaPrato);
	}

	/**
	 * calcola il numero degli elementi presenti
	 *
	 * @return il numero degli elementi presenti
	 */
	public int count() {
		return figure.size();
	}

/*
 * Integer perimetro = figure.stream().parallel()
					.filter(elemento -> elemento != null)
					.reduce( 0, ( a, b) -> a+b );
 *  */
	public BigDecimal siepe() {

		Double perimetro = figure.stream().parallel()
				.filter( elemento -> elemento != null)
				.map( elemento -> elemento.perimetro() * infoSiepi.get(figure.indexOf(elemento)))
				.reduce( 0d, ( a, b ) -> a + b );

//-> (infoSiepi.stream()
		log.debug("Totale dei perimetri={}", perimetro);

		return costoSiepe.multiply(new BigDecimal(perimetro)).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * calcola il preventivo relativo al prato
	 *
	 * @return il valore del preventivo
	 */
	public BigDecimal prato() {
		Double area = figure.stream().parallel()
				.filter( elemento -> elemento != null)
				.map( elemento -> elemento.area() * infoPrati.get(figure.indexOf(elemento)))
				.reduce( 0d, (a, b) -> a + b );


		log.debug("Totale delle aree={}", area);

		return costoPrato.multiply(new BigDecimal(area)).setScale(2, RoundingMode.HALF_UP);
	}

}