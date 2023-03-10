
package com.example.geometria.giardini;

import static com.example.geometria.giardini.Regole.*;

import com.example.database.entity.FiguraGeometricaEntity;
import com.example.geometria.figure.FiguraIrregolare;
import com.example.geometria.figure.Misurabile;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "zone")
public class Zona implements Misurabile, Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Lob
	@Column(nullable=false)
	private String descrizione = "";


	// le due annotation seguenti vanno abilitate per la conversione di Misurabile
	// in una colonna di Zona (ovvero per utilizzare
	// GeometriaSimpleConverter oppure GeometriaSerializationConverter
	// in questo caso disabilitare le annotazioni @PrePersist @PreUpdate @PostLoad
	// e commentare il @Transient per questa colonna
	@Column(name="figura", columnDefinition="text not null")
	@Lob
	// per convertitori	@Transient
	private Misurabile figura;

	@Column(name="funzione_area")
	private /* da Function<Double, Double> ===> */ Regole funzioneArea;

	@Column(name="funzione_perimetro")
	private /* da Function<Double, Double> ===> */ Regole funzionePerimetro;

	@SuppressWarnings("unused")
	private Zona() {
		this(new FiguraIrregolare(0.0, 0.0), ZERO, ZERO);
	}

	public Zona(Misurabile figura, Regole funzionePerimetro, Regole funzioneArea) { // da
		super();
		this.figura = figura;
		this.funzionePerimetro = funzionePerimetro;
		this.funzioneArea = funzioneArea;
	}

	public Zona(Misurabile figura) { // da completare
		this(figura, ADD, ADD);
	}

	public Zona(Double perimetro, Double area, Regole funzionePerimetro,
			Regole funzioneArea) { // da completare
		this(new FiguraIrregolare(area, perimetro), funzionePerimetro, funzioneArea);
	}

	public Zona(Double perimetro, Double area) { // da completare
		this(area, perimetro, ADD, ADD);
	}

	// da completare con calcolo esclusioni
	public double area() {
		return funzioneArea.apply(figura.area()); // by delegation
	}

	// da completare con calcolo esclusioni
	public double perimetro() {
		return funzionePerimetro.apply(figura.perimetro()); // by delegation
	}

	public Zona withPerimetro(Regole f) {
		this.funzionePerimetro = f;
		return this;
	}

	public Zona withArea(Regole f) {
		this.funzioneArea = f;
		return this;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Zona withDescrizione(String descr) {
		setDescrizione(descr);
		return this;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Zona [id=").append(id).append(", descrizione=").append(descrizione).append("]");
		return builder.toString();
	}

	/*
	 * modifiche per demo JPA Events
	 * salvataggio di Misurabile in tabella separata tramite
	 * Entity bridge verso classi di Geometria
	 * */
	/* *** commentata per altro approcci alla persistenza di misurabile ***
	 *
	// metodo di persistenza basato su event handlers
	// commentare tutte le annotazioni seguenti
	// per disabilitare gli eventi e gestire la persistenza serializzando
	// il misurabile tramite gli altri attribute converters
	@OneToOne(cascade=CascadeType.ALL)
	FiguraGeometricaEntity figuraGeometricaEntity = null;

	@PrePersist
	@PreUpdate
	void prePersistAndUpdate() {
		GeometriaMisurabileToEntityConverter converter = new GeometriaMisurabileToEntityConverter();
		figuraGeometricaEntity = converter.convertToDatabaseColumn(figura);
	}

	@PostLoad
	void postLoad() {
		GeometriaMisurabileToEntityConverter converter = new GeometriaMisurabileToEntityConverter();
		figura = converter.convertToEntityAttribute(figuraGeometricaEntity);
		figuraGeometricaEntity = null;
	}
*/
}
