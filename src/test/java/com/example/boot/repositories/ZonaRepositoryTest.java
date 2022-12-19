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

import com.example.geometria.figure.Quadrato;
import com.example.geometria.giardini.Regole;
import com.example.geometria.giardini.Zona;

@SpringBootTest
class ZonaRepositoryTest {
	private static final Logger log = LogManager.getLogger(ZonaRepositoryTest.class);

	@Autowired ZonaRepository repo;
	@Test
	void testFindAll() {
		log.info("Classe implementante il repo {}", repo.getClass().getName());
		List<Zona> zone = repo.findAll();
		//assertTrue(zone.size() > 0);
		// regioni.forEach(regione -> log.info("", regione));
		zone.forEach(log::info); // method references
	}

	@Test
	void testSave() {
		Quadrato quadrato = new Quadrato(4);
		Zona zona = new Zona(quadrato).withDescrizione("quadrato test");
		zona = repo.save(zona);
		zona = new Zona(quadrato).withDescrizione("prova").withPerimetro(Regole.DOUBLE);
		repo.save(zona);

	}

	@Test
	void testFindById() {
		List<Zona> zone = repo.findAll();
        Collections.shuffle(zone);
        assertTrue(zone.size()>0);
        Optional<Zona> opt = repo.findById(zone.get(0).getId());
        assert(opt.isPresent());
        log.debug("eccomi!!{}",opt.get());
	}

}
