package com.example.geometria.giardini;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.geometria.figure.Misurabile;

public class Preventivo {

	private static final Logger log = LogManager.getLogger(Preventivo.class);

	private List<Misurabile> figure = new ArrayList<>();

	private BigDecimal costoPrato = new BigDecimal(5);

	private BigDecimal costoSiepe = new BigDecimal(20);

	public Preventivo () {
		super ();
		log.info("Preparazione dell'oggetto preventivo");
	}

	public Zona add(Misurabile m, Function<Double, Double> valorizzaSiepe, Function<Double, Double> valorizzaPrato) {
		log.trace("passato da add(Misurabile f, Boolean valorizzaSiepe, Boolean valorizzaPrato) {}",m); // trace
		if(m == null) {
			log.warn("passato null alla add, ignorato");
			return null;
		}
		// figure.add(f);
		Zona z = new Zona(m, valorizzaSiepe, valorizzaPrato);
		figure.add( z );
		return z;
	}

	/**
	 * aggiunge una figura al preventivo
	 * @param f la figura
	 */
	public Zona add(Misurabile f) {
		log.trace("passato da add (Misurable f){}" +f);
		return add(f, Zona.ADD, Zona.ADD);
	}

	/**
	 * calcola il numero degli elementi presenti
	 * @return il numero degli elementi presenti
	 */
	public int count() {
		return figure.size();
	}

	/**
	 * calcola il preventivo relativo alla siepe
	 * @return il valore del preventivo
	 */
	public BigDecimal siepe() {
		double perimetro = figure
				.stream().parallel()
				.filter(figura -> figura != null) // inserita solo per fare un esempio
				.mapToDouble(zona -> zona.perimetro())
				.reduce(0.0, (subtotale, nuovoValore) -> subtotale+nuovoValore); // 2 parametri ingresso + uscita
		log.debug("Totale dei perimetri={}", perimetro);
		return costoSiepe.multiply( new BigDecimal(perimetro) ).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * calcola il preventivo relativo al prato
	 * @return il valore del preventivo
	 */
	public BigDecimal prato() {
		double area = figure
				.stream().parallel()
				.filter(figura -> figura != null) // inserita solo per fare un esempio
				.mapToDouble(zona -> zona.area())
				//.reduce(0.0, (subtotal, current) -> subtotal + current);
				.reduce(0.0, this::somma); // using method reference, 2 parametri ingresso (Double, Double) + valore uscita (Double)
		log.debug("Totale delle aree={}", area);
		return costoPrato.multiply( new BigDecimal(area) ).setScale(2, RoundingMode.HALF_UP);
	}




	public void print() {
		// figure.forEach( el -> System.out.println(el) );
		figure.forEach(System.out::println); //oggetto::metodo match con signature di Consumer
	}

	private Double somma(Double x, Double y) {
		return x+y;
	}
}