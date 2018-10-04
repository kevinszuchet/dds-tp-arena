package model.asignaciones;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import model.Alumno;

public class Tarea {
	
	@JsonProperty("title")
	private String nombre;
	
	@JsonProperty("description")
	private String descripcion;
	
	public Tarea() {}
	
	public Tarea(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void asignarA(Alumno alumno, List<Calificacion> calificaciones) {
		alumno.agregarAsignacion(new Asignacion(this, calificaciones));
	}
}
