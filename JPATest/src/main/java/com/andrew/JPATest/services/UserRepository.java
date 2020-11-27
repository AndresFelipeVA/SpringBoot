package com.andrew.JPATest.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrew.JPATest.entities.User;

//Esta interfaz al extender JPARepository permite hacer uso de los metodos tipicos
//usados con una DB con tan solo proveer la entidad que queremos enlazar su clave primaria
//Asi es un atajo a implementar los Data Access Object a cada entidad que usemos
public interface UserRepository extends JpaRepository<User, Long>{

}
