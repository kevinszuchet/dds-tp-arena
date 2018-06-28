package model;

import java.util.List;

public class Tarea {
	private TipoCalificacion tipoCalificacion;
	
	public void validarCalificacion(Calificacion calificacion) {
		// TODO tipoCalificacion.validar(calificacion);
	}
	
	public void asignarA(Alumno alumno, List<Calificacion> calificaciones) {
		alumno.agregarAsignacion(new Asignacion(this, calificaciones));
	}
}
