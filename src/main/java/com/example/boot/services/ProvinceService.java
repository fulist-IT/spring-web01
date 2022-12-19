package com.example.boot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.repositories.ProvinceRepository;
import com.example.boot.repositories.RegioniRepository;
import com.example.database.entity.Provincia;
import com.example.database.entity.Regione;

@Service
public class ProvinceService {
	private static final Logger log = LogManager.getLogger(ProvinceService.class);
	@Autowired ProvinceRepository repo;

	public List<Provincia> findAll() {
        log.trace("findAll()");
		log.info("Classe implementante il repository {}", repo.getClass().getName());
        // possiamo elaborare i dati
        // escludere tutte le regioni in cui id è dispari
        return repo.findAll()
        		.stream().parallel()
        		.collect(Collectors.toList());
    }

	public Optional<Provincia> findById(Integer id) {
		log.trace("findById({})", id);
		return repo.findById(id);
	}

}
