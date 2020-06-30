package com.jfuentes.app.model;


public class Todo {

	private static int contador = 1;
	
	private int id;
	private String titulo;
	private String descripcion;
	
	public Todo() {
		this.id = contador;
		contador++;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}

}
