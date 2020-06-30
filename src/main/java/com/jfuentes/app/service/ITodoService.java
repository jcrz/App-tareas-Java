package com.jfuentes.app.service;

import java.util.List;

import com.jfuentes.app.model.Todo;

public interface ITodoService {
	
	List<Todo> listar();
	void guardar(Todo todo);
	Todo buscarPorId(int id);
	void eliminar(int id);
}
