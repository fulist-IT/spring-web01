package com.example.geometria.giardini;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.geometria.figure.Misurabile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "preventivi")
public class Preventivo implements Serializable{

	private static final Logger log = LogManager.getLogger(Preventivo.class);
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Lob
	@Column(nullable=false, name="nome_cliente")
	private String nomeCliente;

	@Lob
	@Column(nullable=false, name="cognome_cliente")
	private String cognomeCliente;

	@Lob
	@Column(nullable=false)
	private String indirizzo;

	@Lob
	@Column(nullable=false)
	private String telefono;

	@Lob
	@Column(nullable=false, name="data_creazione")
	private final String dataCreazione = LocalDateTime.now().toString();

	@Lob
	@Column(nullable=false, name="data_modifiche")
	private String dataModifiche = LocalDateTime.now().toString();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="preventivo_id", referencedColumnName="id")
	private List<Zona> figure = new ArrayList<>();
	//private List<Misurabile> figure = new ArrayList<>(); // commentato per compatibilità con JPA

	@Column(nullable=false, name="costo_prato")
	private BigDecimal costoPrato = new BigDecimal(5);

	@Column(nullable=false, name="costo_siepe")
	private BigDecimal costoSiepe = new BigDecimal(20);

	@SuppressWarnings("unused")
	private Preventivo () {
		super ();
		log.info("Preparazione dell'oggetto preventivo");
	}

	public Preventivo (String nomeCliente,String cognomeCliente,String indirizzo, String telefono) {
		super ();
		log.info("Preparazione dell'oggetto preventivo");
		this.nomeCliente = nomeCliente;
		this.cognomeCliente = cognomeCliente;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
	}

	public Zona add(Misurabile m, Regole valorizzaSiepe, Regole valorizzaPrato) {
		log.trace("passato da add(Misurabile m, Regole valorizzaSiepe, Regole valorizzaPrato) {}",m); // trace
		if(m == null) {
			log.warn("passato null alla add, ignorato");
			return null;
		}

		Zona z = new Zona(m, valorizzaSiepe, valorizzaPrato);
//		z.setPreventivo(this); // collego zona e preventivo per la JPA
		figure.add( z );
		updateData();
		return z;
	}

	/**
	 * aggiunge una figura al preventivo
	 * @param f la figura
	 */
	public Zona add(Misurabile f) {
		log.trace("passato da add (Misurable f){}", f);
		return add(f, Regole.ADD, Regole.ADD);
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCognomeCliente() {
		return cognomeCliente;
	}

	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Preventivo withNomeCliente(String nomeCliente) {
		setNomeCliente(nomeCliente);
		return this;
	}

	public Preventivo withCognomeCliente(String cognomeCliente) {
		setCognomeCliente(cognomeCliente);
		return this;
	}

	public Preventivo withIndirizzo(String indirizzo) {
		setIndirizzo(indirizzo);
		return this;
	}

	public Preventivo withTelefono(String telefono) {
		setTelefono(telefono);
		return this;
	}

	private void updateData () {
		this.dataModifiche = LocalDateTime.now().toString();
	}

	public String getDataCreazione() {
		return dataCreazione;
	}

	public String getDataModifiche() {
		return dataModifiche;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Preventivo [id=").append(id).append(", nomeCliente=").append(nomeCliente)
				.append(", cognomeCliente=").append(cognomeCliente).append(", indirizzo=").append(indirizzo)
				.append(", telefono=").append(telefono).append(", dataCreazione=").append(dataCreazione)
				.append(", dataModifiche=").append(dataModifiche).append(", costoPrato=").append(costoPrato)
				.append(", costoSiepe=").append(costoSiepe).append("]");
		return builder.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
