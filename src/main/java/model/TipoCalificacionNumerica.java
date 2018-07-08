package model;

import java.util.List;

public class TipoCalificacionNumerica implements TipoCalificacion<CalificacionNumerica> {
	private final int seApruebaCon = 6;
	
	public boolean calificacionesAprobadas(List<CalificacionNumerica> calificaciones) {
		return calificaciones.stream().allMatch(calificacion -> this.calificacionAprobada(calificacion));
	}
	
	public boolean calificacionAprobada(CalificacionNumerica calificacion) {
		return calificacion.getValor() >= seApruebaCon;
	}
}
