package com.example.boot.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.services.ProvinceService;
import com.example.boot.services.RegioniService;
import com.example.database.entity.Regione;

//
// il path (=URI/URL) che individual la risorsa REST (il metodo del controller)
// è dato dalla concatenazione di @RequestMapping con i vari #<metodo>Mapping
// @RequestMapping = /item/funzioni
// @PostMapping = /sottofunzione/{parametro}
// il metodo individuato ha la seguente URL
// http://<server>/item/funzioni/sottofunzione/33, il metodo sara raggiungibile solo tramite POST

@RestController
@RequestMapping("/regioni")
public class RegioniRestController {
	private static final Logger log = LogManager.getLogger(RegioniRestController.class);

	@Autowired RegioniService service;

	@GetMapping
	public ResponseEntity<List<Regione>> findAll() {
		List<Regione> regioni = service.findAll();
		return new ResponseEntity<>(regioni, HttpStatus.OK);
	}

	@GetMapping(path="/{id}") // url=/regioni/id
	public ResponseEntity<Regione> findById(@PathVariable("id") Integer id) {
		Optional<Regione> regione = service.findById(id);
		if(regione.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(regione.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Regione> save(@RequestBody Regione r) {

		// chiama al service per inserimento regione

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping
	public ResponseEntity<Regione> update(@RequestBody Regione r) {

		// chiama al service per aggiornamento regione

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {

		// chiama al service per cancellazione regione

		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

}
