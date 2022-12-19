package com.example.database.entity;

import com.example.geometria.figure.Cerchio;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue( value="cerchio" )
public class CerchioEntity extends EllisseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="raggio")
	private Double raggio;

	public CerchioEntity() {
		super();
	}

	public CerchioEntity(Cerchio cerchio) {
		super();
		this.raggio = cerchio.getRaggio();
	}

	public Double getRaggio() {
		return raggio;
	}

	@Override
	public Cerchio toFiguraGeometrica() {
		return new Cerchio(raggio);
	}

}
