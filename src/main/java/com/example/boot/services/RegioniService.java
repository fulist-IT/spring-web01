package com.example.boot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.repositories.RegioniRepository;
import com.example.database.entity.Regione;

@Service
public class RegioniService {
	private static final Logger log = LogManager.getLogger(RegioniService.class);
	@Autowired RegioniRepository repo;

	public List<Regione> findAll() {
        log.trace("findAll()");
        // possiamo elaborare i dati
        // escludere tutte le regioni in cui id è dispari
        return repo.findAll()
        		.stream().parallel()
        		//.filter(regione -> regione.getId()%2 == 0)
        		.collect(Collectors.toList());
    }

	public Optional<Regione> findById(Integer id) {
		log.trace("findById({})", id);
		return repo.findById(id);
	}

}
