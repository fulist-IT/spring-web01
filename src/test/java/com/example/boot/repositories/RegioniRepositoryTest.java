package com.example.boot.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.boot.services.RegioniService;
import com.example.database.entity.Regione;

@SpringBootTest
class RegioniRepositoryTest {
	private static final Logger log = LogManager.getLogger(RegioniRepositoryTest.class);
	@Autowired RegioniService service;
	@Test
    void testFindAllExampleOfS() {
        log.info("Classe implementante il repository {}", service.getClass().getName());
        List<Regione> regioni = service.findAll();
        assertTrue(regioni.size() > 0);
        // regioni.forEach(regione -> log.info("", regione));
        regioni.forEach(log::info); // method references
    }

	@Test
    void testFindById() {
		log.info("Classe implementante il repository {}", service.getClass().getName());
        List<Regione> regioni = service.findAll();
        Collections.shuffle(regioni);
        Optional<Regione> opt = service.findById(regioni.get(0).getId());
        assert(opt.isPresent());
        log.debug("eccomi!!{}", opt.get());


    }
}