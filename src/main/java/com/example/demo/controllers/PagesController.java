package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

	@GetMapping("/")
	private String Home() {
		return "index";
	}
	
	@GetMapping("/ajoutReservation")
	private String addRtn() {
		return "reservation";
	}
}
