package com.example.database.entity;

import com.example.geometria.figure.Ellisse;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( value="ellisse" )
public class EllisseEntity extends FiguraGeometricaEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="semiasse_minore")
	private Double semiasseMinore;

	@Column(name="semiasse_maggiore")
	private Double semiasseMaggiore;

	public EllisseEntity() {
		super();
	}

	public EllisseEntity(Ellisse ellisse) {
		super();
		this.semiasseMinore = ellisse.getSemiasseMinore();
		this.semiasseMaggiore = ellisse.getSemiasseMaggiore();
	}

	public Double getSemiasseMinore() {
		return semiasseMinore;
	}

	public Double getSemiasseMaggiore() {
		return semiasseMaggiore;
	}

	@Override
	public Ellisse toFiguraGeometrica() {
		return new Ellisse(semiasseMinore, semiasseMaggiore);
	}

}
