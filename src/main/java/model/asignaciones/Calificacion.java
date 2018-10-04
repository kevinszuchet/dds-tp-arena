package model.asignaciones;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import json.CalificacionDeserializer;

@JsonDeserialize(using = CalificacionDeserializer.class)
public abstract class Calificacion {	
	public abstract String getCalificacion();
	public abstract boolean estaAprobada();
}
