package com.pruebaAlmundo.entidades;

/**
 * 
 * @author Sergio Forero
 *
 */
public class Empleado {

	private String nombre;
	private String tipo;
	private boolean estado;

	public Empleado(String nombre, String tipo, boolean estado) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
