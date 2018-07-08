package model;

import java.util.List;

public class Tarea {
	private TipoCalificacion<Calificacion> tipoCalificacion;
	
	public void asignarA(Alumno alumno, List<Calificacion> calificaciones) {
		alumno.agregarAsignacion(new Asignacion(this, calificaciones));
	}
	
	public boolean asignacionAprobada(Asignacion asignacion) {
		return tipoCalificacion.calificacionesAprobadas(asignacion.getCalificaciones());
	}
}
