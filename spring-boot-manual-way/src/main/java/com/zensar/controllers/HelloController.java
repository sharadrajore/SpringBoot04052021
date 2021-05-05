package com.zensar.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	// http://localhost:8080/
	
	@RequestMapping("/")
	public String sayHello() {
		return "<h2> Hello from Spring Boot </h2>";
	}
	
	
	// http://localhost:8080/hi
	@RequestMapping("/hi")
	public String sayHi() {
		return "<h2> HI from Spring Boot </h2>";
	}

}
