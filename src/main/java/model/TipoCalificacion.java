package model;

import java.util.List;

@SuppressWarnings("hiding")
public abstract class TipoCalificacion<Calificacion> {
	public abstract boolean calificacionAprobada(Calificacion calificacion);
	public abstract boolean calificacionesAprobadas(List<Calificacion> calificaciones);	
}
