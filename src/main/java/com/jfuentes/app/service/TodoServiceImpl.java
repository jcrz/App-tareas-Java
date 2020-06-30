package com.jfuentes.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jfuentes.app.model.Todo;

@Service
public class TodoServiceImpl implements ITodoService {

	private List<Todo> lista = null;
	
	public TodoServiceImpl() {
		lista = new LinkedList<Todo>();
		
		// Crea un nuevo objeto 
		Todo tarea1 = new Todo();
		tarea1.setTitulo("Tarea #1");
		tarea1.setDescripcion("Realizar los objetivos de la tarea.");
		
		// Crea un nuevo objeto 
		Todo tarea2 = new Todo();
		tarea2.setTitulo("Tarea #2");
		tarea2.setDescripcion("Realizar los objetivos de la tarea.");
		
		
		//llena la lista 
		lista.add(tarea1);
		lista.add(tarea2);
	}
	
	@Override
	public List<Todo> listar() {
		return lista;
	}

	@Override
	public void guardar(Todo todo) {
		lista.add(todo);
	}

	@Override
	public Todo buscarPorId(int id) {
		for (Todo td : lista) {
			if (td.getId() == id) {
				return td;
			}
		}
		return null;
	}

	@Override
	public void eliminar(int id) {
		for (Todo td : lista) {
			if (td.getId() == id) {
				lista.remove(td);
			}
		}
	}

}
