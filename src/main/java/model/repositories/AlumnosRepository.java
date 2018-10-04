package model.repositories;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;

import json.JSONParser;
import model.Alumno;
import model.asignaciones.Asignacion;

public class AlumnosRepository extends Repositorios {
	
	private static JSONParser<Alumno> parserAlumnos = new JSONParser<Alumno>();
	private static AlumnosRepository instance = null;
	
	private static final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";
	
	
	public static AlumnosRepository getInstance() {
		if (instance == null) {
			instance = new AlumnosRepository();
		}
		return instance;		
	}
	
	public static Alumno getXlegajo(long legajo) {
		// TODO: ver de filtrar por legajo o algo por el estilo
		
		ClientResponse response = requester.getStudentByToken(token);
		String json = response.getEntity(String.class);
		
		Alumno alumno = parserAlumnos.jsonToObject(json, Alumno.class);		
		if (alumno.getLegajo() != legajo) {
			throw new NoExisteLegajoIngresadoException();
		}
		
		List<Asignacion> asignaciones = AsignacionesRepository.getInstance().obtenerXalumno(alumno);
		alumno.setAsignaciones(asignaciones);
		
		return alumno;
	}

	public void modificar(Alumno alumno) {
		// TODO: revisar si esta bien que el repo tenga la responsabilidad de modificar
		requester.updateStudentByToken(token, alumno);
	}
}
