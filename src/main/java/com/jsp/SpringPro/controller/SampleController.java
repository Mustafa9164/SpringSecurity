package com.jsp.SpringPro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@GetMapping("/api1")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	String m1() {
		return "<h1>I AM Api-1</h1>";
	}
	
	@GetMapping("/api2")
	String m2() {
		return "<h1>I AM Api-2</h1>";
	}
	@GetMapping("/api3")
	String m3() {
		return "<h1>I AM Api-3</h1>";
	}
	@GetMapping("/api4")
	String m4() {
		return "<h1>I AM Api-4</h1>";
	}

}
