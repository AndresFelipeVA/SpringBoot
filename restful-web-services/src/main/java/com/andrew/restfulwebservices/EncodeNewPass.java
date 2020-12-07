package com.andrew.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeNewPass {

	public static void main(String[] args) {
		BCryptPasswordEncoder codificado= new BCryptPasswordEncoder();
		String codifString =codificado.encode("test");
		System.out.println(codifString);
		
		

	}

}
