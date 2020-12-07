package com.andrew.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static long idCounter=0;
	
	static {
		todos.add(new Todo(++idCounter, "Andres", "Learn SpringBoot", new Date(), false));
		todos.add(new Todo(++idCounter, "Andres", "Learn MicroServices", new Date(), false));
		todos.add(new Todo(++idCounter, "Andres", "Learn Angular", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public boolean deleteById(long id) {
		Todo todoDel = findById(id);
		if(todoDel==null) {
			return false;//Si no encontro el elemento no hay nada que remover
		}
		return todos.remove(todoDel);
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}

	public Todo save(Todo todo) {
		if(todo.getId()==-1) {
			//adicionar un nuevo todo
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			//TODO: probar con el metodo remove(id) a ver si no se desorganiza la lista
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
}
