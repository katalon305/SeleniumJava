package com.demo;

public class Personas {
	private String nombre;
	private String apellido;
	
	public Personas(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public void saludar() {
		System.out.println("Hola: " + this.nombre + " " + this.apellido);
	}

}
