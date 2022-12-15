package com.example.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Regione;

@Repository
public interface RegioniRepository extends JpaRepository<Regione,Integer>{

}
