package com.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.boot.services.HelloService;

@SpringBootApplication
@EntityScan(basePackages = "com.example")		//questo rigo e il successivo servono per dire al 
@ComponentScan(basePackages = "com.example")	//precedente rigo che deve cercare pachetti esterni a com.example.boot
public class SpringWeb01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeb01Application.class, args);
	}

	@Bean(initMethod = "init", destroyMethod = "destroy")
	HelloService helloService() {
		return new HelloService();
	}
}
