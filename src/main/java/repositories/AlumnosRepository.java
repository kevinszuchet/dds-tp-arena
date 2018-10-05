package repositories;

import com.sun.jersey.api.client.ClientResponse;

import json.JSONParser;
import model.Alumno;

public class AlumnosRepository extends Repositorios {
	
	private static JSONParser<Alumno> parserAlumnos = new JSONParser<Alumno>();
	private static AlumnosRepository instance = null;	
	
	public static AlumnosRepository getInstance() {
		if (instance == null) {
			instance = new AlumnosRepository();
		}
		return instance;		
	}
	
	public static Alumno getXlegajo(long legajo) {
		// TODO: ver de filtrar por legajo o algo por el estilo
		
		ClientResponse response = requester.getStudent();
		String json = response.getEntity(String.class);
		
		Alumno alumno = parserAlumnos.jsonToObject(json, Alumno.class);		
		if (alumno.getLegajo() != legajo) {
			throw new NoExisteLegajoIngresadoException();
		}
		
		// Obtengo las asignaciones, a partir de un alumno (vacio)
		// TODO: revisar esto, esta horrible
		response = requester.getStudentAssignments();
		json = response.getEntity(String.class);
		Alumno alumnoConAsignaciones = parserAlumnos.jsonToObject(json, Alumno.class);
		
		alumno.setAsignaciones(alumnoConAsignaciones.getAsignaciones());
		
		return alumno;
	}

	public void modificar(Alumno alumno) {
		// TODO: revisar si esta bien que el repo tenga la responsabilidad de modificar al estudiante
		requester.updateStudent(alumno);
	}
}
