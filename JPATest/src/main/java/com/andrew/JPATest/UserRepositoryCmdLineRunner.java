package com.andrew.JPATest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.andrew.JPATest.entities.User;
import com.andrew.JPATest.services.UserRepository;

//Este Command Line Runner reemplaza el que usa el DAOService
@Component
public class UserRepositoryCmdLineRunner implements CommandLineRunner{

	private static final Logger log =
			LoggerFactory.getLogger(UserRepositoryCmdLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user=new User("Felipe", "Admin");
		userRepository.save(user);
		log.info("Nuevo usuario creado en repo:"+user);
		
		Optional<User> user1 = userRepository.findById(1L);
		log.info("Usuario obtenido con id 1:"+user1);
		
		List<User> users = userRepository.findAll();
		log.info("Lista de Usuarios:"+users);
	}

}
