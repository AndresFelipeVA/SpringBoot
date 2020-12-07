package com.andrew.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoJPAResource {
	
//	@Autowired
//	private TodoHardcodedService todoService;
	
	@Autowired
	private TodoJPARepository todoJPAService;

	@GetMapping("/JPA/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoJPAService.findByUserName(username);
		//Asi buscamos los referentes a un usuario y no todos los ToDo 
		//return todoJPAService.findAll();
	}
	
	@GetMapping("/JPA/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
		return todoJPAService.findById(id).get();
	}
//TODO: para que sirve este id aca si ya esta en el todo
	@PutMapping("/JPA/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, 
										@PathVariable long id,
										@RequestBody Todo todo){
		Todo todoUpdated = todoJPAService.save(todo);//todoService.save(todo);
		//Podriamos retornar solo el Todo pero asi tenemos probamos mas capacidades de Springboot
		//o retornar solo un estado de que funciono correctamente
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
	}

	@PostMapping("/JPA/users/{username}/todos")
	public ResponseEntity<Void> addTodo(@PathVariable String username,
										@RequestBody Todo todo){
		todo.setUserName(username);
		Todo todoSaved = todoJPAService.save(todo);
		//En un post tipicamente se devuelve el url del recien creado recurso
		//Igualmente asi exploramos mas capacidades del SpringBoot
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(todoSaved.getId()).toUri();//.build(todoSaved.getId());
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/JPA/users/{username}/todos/{id}")
	public ResponseEntity<Void> getAllTodos(@PathVariable String username, @PathVariable long id){

		 todoJPAService.deleteById(id);
		 return ResponseEntity.noContent().build(); }

}
