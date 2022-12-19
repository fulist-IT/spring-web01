package com.example.database.entity;

import java.io.Serializable;

import com.example.geometria.figure.FiguraGeometrica;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "figure_geometriche")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name = "ztype" )
@DiscriminatorValue( value="figura-geometrica" )
public abstract class FiguraGeometricaEntity implements Serializable/* extends Object implements Misurabile */ {

	private static final long serialVersionUID = 1L;

	public FiguraGeometricaEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	public abstract FiguraGeometrica toFiguraGeometrica();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
