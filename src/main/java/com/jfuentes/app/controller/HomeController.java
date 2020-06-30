package com.jfuentes.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jfuentes.app.model.Todo;
import com.jfuentes.app.service.ITodoService;

@Controller
public class HomeController {
	
	@Autowired
	private ITodoService tareaService;
	
	//:8080/
	@GetMapping({"/", ""})
	public String home(Todo todo, Model model) {
		model.addAttribute("todo", todo);
		return "home";
	}
	
	//:8080/listar
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Todo> listado = tareaService.listar();
		model.addAttribute("tareas", listado);
		return "listar";
	}
	
	//:8080/crear
	@PostMapping("/crear")
	public String guardar(Todo todo) {
		tareaService.guardar(todo);
		return "redirect:/listar";
	}
	
	//:8080/editar/{id}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		Todo tarea = tareaService.buscarPorId(id);
		model.addAttribute("todo", tarea);
		return "editar";
	}
	
	//:8080/update
	@PostMapping("/update")
	public String update(@RequestParam("id") int id, @RequestParam("titulo") String titulo, @RequestParam("descripcion") String descripcion) {
		Todo td = tareaService.buscarPorId(id);
		td.setTitulo(titulo);
		td.setDescripcion(descripcion);
		return "redirect:/listar";
	}
	
	//:8080/eliminar/{id}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id) {
		tareaService.eliminar(id);
		return "redirect:/listar";
	}
}
