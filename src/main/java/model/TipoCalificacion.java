package model;

import java.util.List;

public interface TipoCalificacion<TCalificacion> {
	public boolean calificacionAprobada(TCalificacion calificacion);
	public boolean calificacionesAprobadas(List<TCalificacion> calificaciones);	
}
