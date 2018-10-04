package model.asignaciones;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Observable
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asignacion {

	@JsonIgnore
	private Tarea tarea;
	
	@JsonProperty("grades")
	private List<Calificacion> calificaciones = new ArrayList<>();
	
	public Asignacion() {}

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
		return getCalificacionActual().estaAprobada();
	}
	
	public String estaONoAprobada() {
		return getCalificacionActual().estaAprobada() ? "Si" : "No";
	}
	
	public Calificacion getCalificacionActual() {
		return calificaciones.get(calificaciones.size() - 1);
	}
	
	public String getValorCalificacionActual() {
		return getCalificacionActual().getCalificacion();
	}
	
	public String getNombreTarea() {
		return tarea.getNombre();
	}
}
