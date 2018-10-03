package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import json.CalificacionParser;

//@JsonDeserialize(using = CalificacionParser.class)
public interface Calificacion {	
	public String getCalificacion();
	public boolean estaAprobada();
}
