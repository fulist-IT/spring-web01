package com.example.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.geometria.giardini.Zona;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Integer>{

}
