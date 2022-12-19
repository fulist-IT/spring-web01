package com.example.boot.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HelloService {

	private static final Logger log = LogManager.getLogger(HelloService.class);

	public void init() {
		log.trace("init()");
	}

	public void destroy() {
		log.trace("destroy()");
	}

	public String helloMessage() {
		log.trace("helloMessage()");
		return "Hello World";
	}
}
