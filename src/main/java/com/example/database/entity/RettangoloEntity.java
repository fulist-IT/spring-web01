package com.example.database.entity;

import com.example.geometria.figure.Rettangolo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( value="rettangolo" )
public class RettangoloEntity extends FiguraGeometricaEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="base")
	private Double base;

	@Column(name="altezza")
	private Double altezza;

	public RettangoloEntity() {
		super();
	}

	public RettangoloEntity(Rettangolo rettangolo) {
		super();
		this.base = rettangolo.getBase();
		this.altezza = rettangolo.getAltezza();
	}

	public Double getBase() {
		return base;
	}

	public Double getAltezza() {
		return altezza;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public void setAltezza(Double altezza) {
		this.altezza = altezza;
	}

	@Override
	public Rettangolo toFiguraGeometrica() {
		return new Rettangolo(base, altezza);
	}




}
