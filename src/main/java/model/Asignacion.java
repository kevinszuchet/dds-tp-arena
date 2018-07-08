package model;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion {

	private Tarea tarea;
	private List<Calificacion> calificaciones = new ArrayList<>();

	public Asignacion(Tarea tarea, List<Calificacion> calificaciones) {
		this.tarea = tarea;
		this.calificaciones = calificaciones;
	}
	
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	
	public void agregarCalificacion(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	
	public boolean estaAprobada() {
		return tarea.asignacionAprobada(this);
	}
	
	public Calificacion getNotaActual() {
		return calificaciones.get(calificaciones.size() - 1);
	}
}
