package com.example.boot.repositories;

import static com.example.geometria.giardini.Regole.NO;
import static com.example.geometria.giardini.Regole.SI;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.geometria.figure.Cerchio;
import com.example.geometria.figure.Quadrato;
import com.example.geometria.figure.Rettangolo;
import com.example.geometria.giardini.Preventivo;
import com.example.geometria.giardini.Zona;

@SpringBootTest
class PreventivoRepositoryTest {
	private static final Logger log = LogManager.getLogger(PreventivoRepositoryTest.class);

	@Autowired PreventivoRepository repo;
	@Test
	void testSave() {
		Preventivo preventivo = new Preventivo("Attilio","Infame","casa Sua", "cellulare");
		// 2 rettangoli 20x3
		for(int i=0; i<2; i++) {
			preventivo.add( new Rettangolo(20, 3), SI, NO );
		}

		// 6 quadrati di lato 4
		Quadrato q = new Quadrato(4);
		for(int i=0; i<6; i++) {
//			preventivo.add( new Quadrato(4) );
			preventivo.add( q );
		}
		preventivo.add(new Cerchio(2.5)).withArea(NO);
		String report = String.format("Numero aiuole=%s - Costo Prato=%s - Costo Siepe=%s", preventivo.count(), preventivo.prato(), preventivo.siepe());
		System.out.println(report);

		Zona zona = new Zona(new Quadrato(10));
		preventivo.add( zona );

		assertTrue(preventivo.count() > 0);

		preventivo = repo.save(preventivo);

		assertTrue (preventivo.getId()!= null);
	}

	@Test
	void testFindById() {
		List<Preventivo> preventivi = repo.findAll();
        Collections.shuffle(preventivi);
        assertTrue(preventivi.size()>0);
        Optional<Preventivo> opt = repo.findById(preventivi.get(0).getId());
        assert(opt.isPresent());
        log.debug("eccomi!!{}",opt.get());
		//fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		log.info("Classe implementante il repo {}", repo.getClass().getName());
		List<Preventivo> preventivi = repo.findAll();
		assertTrue(preventivi.size() > 0);
		preventivi.forEach(log::info); // method references
		//fail("Not yet implemented");
	}

}
