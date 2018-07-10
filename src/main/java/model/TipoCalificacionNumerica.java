package model;

import java.util.List;

public class TipoCalificacionNumerica extends TipoCalificacion<CalificacionNumerica> {
	private final int seApruebaCon = 6;
	private static TipoCalificacionNumerica instancia;
	
	public static TipoCalificacionNumerica getInstance() {
		if (instancia == null) {
			instancia = new TipoCalificacionNumerica();			
		}
		return instancia;
	}
	
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
