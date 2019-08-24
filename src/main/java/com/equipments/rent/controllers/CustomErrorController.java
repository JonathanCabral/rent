package com.equipments.rent.controllers;

import javax.ws.rs.core.MediaType;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class CustomErrorController implements ErrorController {
	
	private static final String PATH = "/erro-haven";

	@GetMapping(value = PATH, produces = MediaType.APPLICATION_JSON)
	public String error() {
		return "You reach the heaven of erros.";
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}

}
