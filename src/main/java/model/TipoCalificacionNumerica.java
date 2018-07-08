package model;

import java.util.List;

public class TipoCalificacionNumerica implements TipoCalificacion<CalificacionNumerica> {
	private final int seApruebaCon = 6;
	
	public boolean calificacionesAprobadas(List<CalificacionNumerica> calificaciones) {
		return this.ultimaCalificacionAprobada(calificaciones);
	}
	
	public boolean ultimaCalificacionAprobada(List<CalificacionNumerica> calificaciones) {
		CalificacionNumerica ultCalificacion = calificaciones.get(calificaciones.size() - 1);
		return this.calificacionAprobada(ultCalificacion);
	}
	
	public boolean calificacionAprobada(CalificacionNumerica calificacion) {
		return calificacion.getValor() >= seApruebaCon;
	}
}
