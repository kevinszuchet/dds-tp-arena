package model;

import java.util.List;

public class Tarea {
	
	private String nombre;
	private String descripcion;
	public Tarea(String nombre) {
		this.nombre = nombre;		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void asignarA(Alumno alumno, List<Calificacion> calificaciones) {
		alumno.agregarAsignacion(new Asignacion(this, calificaciones));
	}
}
