package com.example.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.boot.services.HelloService;

@SpringBootTest
class SpringWeb01ApplicationTests {

	// IoC e DI: la ns classe (SpringWeb01ApplicationTests) dichiara di dipendere da HelloService
	// e spring riempie in automatico la dipendenza.
	@Autowired HelloService hs = null; // dependency injection

	@Test
	void contextLoads() {
		// 1) ottenere un'istanza di HelloService
		// 2) stampare il risultato di .helloMessage()
		System.out.println( hs.helloMessage() );
	}

}