package com.test.service1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/api")
	public String sayHello() {
		return "Hello service1";
	}
}
