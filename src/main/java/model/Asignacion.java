package model;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

@Observable
public class Asignacion {

	private Tarea tarea;
	private List<Calificacion> calificaciones = new ArrayList<Calificacion>();

	public Asignacion(Tarea tarea, List<Calificacion> calificaciones) {
		this.tarea = tarea;
		calificaciones.forEach(calificacion -> tarea.validarCalificacion(calificacion));
		this.calificaciones = calificaciones;
	}
	
	public void agregarCalificacion(Calificacion calificacion) {
		tarea.validarCalificacion(calificacion);
		calificaciones.add(calificacion);
	}
}
