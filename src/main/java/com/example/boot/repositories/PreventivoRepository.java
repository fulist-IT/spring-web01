package com.example.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.geometria.giardini.Preventivo;

    @Repository
	public interface PreventivoRepository extends JpaRepository<Preventivo, Integer>{

    }
