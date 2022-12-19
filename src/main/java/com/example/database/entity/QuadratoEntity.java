package com.example.database.entity;

import com.example.geometria.figure.Quadrato;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( value="quadrato" )
public class QuadratoEntity extends FiguraGeometricaEntity {
	private static final long serialVersionUID = 1L;

	private Double lato;

	public QuadratoEntity(Quadrato quadrato) {
		super();
		this.lato = quadrato.getLato();
	}

	public Double getLato() {
		return lato;
	}

	@Override
	public Quadrato toFiguraGeometrica() {
		return new Quadrato(lato);
	}

}
