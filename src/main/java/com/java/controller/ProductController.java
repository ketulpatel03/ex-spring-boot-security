package com.java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping("/welcome")
	public ResponseEntity<Object> welcomeMsg(){
		return ResponseEntity.status(HttpStatus.OK).body("welcome lol.....");
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Object> welcomeMsgAdmin(){
		return ResponseEntity.status(HttpStatus.OK).body("admin lol.....");
	}

	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<Object> welcomeMsgUser(){
		return ResponseEntity.status(HttpStatus.OK).body("user lol.....");
	}

}
