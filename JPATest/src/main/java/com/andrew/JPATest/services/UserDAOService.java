package com.andrew.JPATest.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.andrew.JPATest.entities.User;

@Repository
@Transactional
public class UserDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}

}