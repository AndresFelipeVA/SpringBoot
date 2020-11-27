package com.andrew.JPATest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.andrew.JPATest.entities.User;
import com.andrew.JPATest.services.UserDAOService;

@Component
public class UserDAOServiceCmdLineRunner implements CommandLineRunner{

	private static final Logger log =
			LoggerFactory.getLogger(UserDAOServiceCmdLineRunner.class);
	
	@Autowired
	private UserDAOService userDAOService;
	
	@Override
	public void run(String... args) throws Exception {
		User user=new User("Andres", "Admin");
		//TODO: no veo para que este metodo devuelve un long
		userDAOService.insert(user);
		log.info("Nuevo usuario creado:"+user);
	}

}
