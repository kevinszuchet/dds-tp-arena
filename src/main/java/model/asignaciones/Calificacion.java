package model.asignaciones;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import json.CalificacionDeserializer;

@JsonDeserialize(using = CalificacionDeserializer.class)
public interface Calificacion {	
	public String getCalificacion();
	public boolean estaAprobada();
}
