package com.durgesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.AuthRequest;

@RestController
public class Login {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@GetMapping("/Admin")
	public String login()
	{
		return "this Is Login Page ";
	}
	
	@PostMapping("/Auth")
	public ResponseEntity<?> login(@RequestBody  AuthRequest authRequest)
	{
		System.out.println(authRequest.getEmail());
		System.out.println(authRequest.getPassword());
//		if(passwordEncoder.matches(authRequest.getPassword(),null)) {
//			System.out.println("Password Match");
//			return "Credential okay ";
//		}
		
		
		
		return new ResponseEntity<>("Okay",HttpStatus.OK);
	}

}
