package com.example.boot.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.services.ProvinceService;
import com.example.boot.services.RegioniService;
import com.example.database.entity.Provincia;
import com.example.database.entity.Regione;

@RestController
@RequestMapping("/province")
public class ProvinciaRestController {
	private static final Logger log = LogManager.getLogger(ProvinciaRestController.class);

	@Autowired ProvinceService service;

	@GetMapping
	public ResponseEntity<List<Provincia>> findAll() {
		List<Provincia> provincia = service.findAll();
		return new ResponseEntity<>(provincia, HttpStatus.OK);
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Provincia> findById(@PathVariable("id") Integer id) {
		Optional<Provincia> provincia = service.findById(id);
		if(provincia.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(provincia.get(), HttpStatus.OK);
	}


}
