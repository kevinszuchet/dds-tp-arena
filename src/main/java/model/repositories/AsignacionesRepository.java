package model.repositories;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;

import json.JSONParser;
import model.Alumno;
import model.asignaciones.Asignacion;

public class AsignacionesRepository extends Repositorios {
	
	private static JSONParser<Asignacion> parserAsignaciones = new JSONParser<Asignacion>();
	private static AsignacionesRepository instance = null;
	
	private static final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	
	
	public static AsignacionesRepository getInstance() {
		if (instance == null) {
			instance = new AsignacionesRepository();
		}
		return instance;		
	}

	public List<Asignacion> obtenerXalumno(Alumno alumno) {
		// TODO: obtener por el token del alumno
		ClientResponse response = requester.getStudentAssignmentsByToken(token);
		String json = response.getEntity(String.class);
		return parserAsignaciones.jsonToObjectList(json, Asignacion.class);
	}
}