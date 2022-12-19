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

import com.example.boot.services.ProvinceService;
import com.example.database.entity.Provincia;
import com.example.database.entity.Regione;

@SpringBootTest
class ProvinceRepositoryTest {
	private static final Logger log = LogManager.getLogger(ProvinceRepositoryTest.class);
	@Autowired ProvinceService service;
	@Test

	void testFindById() {
		List<Provincia> province = service.findAll();
        Collections.shuffle(province);
        assertTrue(province.size()>0);
        Optional<Provincia> opt = service.findById(province.get(0).getId());
        assert(opt.isPresent());
        log.debug("eccomi!!{}",opt.get());
	}

	@Test
	void testFindAll() {
		log.info("Classe implementante il service {}", service.getClass().getName());
		List<Provincia> province = service.findAll();
		assertTrue(province.size() > 0);
		// regioni.forEach(regione -> log.info("", regione));
		province.forEach(log::info); // method references
	}

}
