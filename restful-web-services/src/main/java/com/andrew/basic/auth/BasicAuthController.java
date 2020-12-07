package com.andrew.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthController {
	

	@GetMapping(path = "/basic-auth")
	public BasicAuthBean basicAuthBean() {
		return new BasicAuthBean("Basic Authentication in Backend Successful");
	}
	
}
