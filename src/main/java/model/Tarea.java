package model;

import java.util.List;

public class Tarea {
	private String nombre;
	private TipoCalificacion<Calificacion> tipoCalificacion;
	
	public Tarea(String nombre, TipoCalificacion<Calificacion> tipoCalificacion) {
		this.nombre = nombre;
		this.tipoCalificacion = tipoCalificacion;		
	}
	
	public String getnombre() {
		return nombre;
	}
	
	public void asignarA(Alumno alumno, List<Calificacion> calificaciones) {
		alumno.agregarAsignacion(new Asignacion(this, calificaciones));
	}
	
	public boolean asignacionAprobada(Asignacion asignacion) {
		return tipoCalificacion.calificacionesAprobadas(asignacion.getCalificaciones());
	}
}
