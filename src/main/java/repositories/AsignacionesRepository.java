package repositories;

import com.sun.jersey.api.client.ClientResponse;

import json.JSONParser;
import model.Alumno;
import model.asignaciones.Asignacion;

public class AsignacionesRepository extends Repositorios {
	
	private static JSONParser<Asignacion> parserAsignaciones = new JSONParser<Asignacion>();
	private static AsignacionesRepository instance = null;	
	
	public static AsignacionesRepository getInstance() {
		if (instance == null) {
			instance = new AsignacionesRepository();
		}
		return instance;		
	}

	public void asociarAsignaciones(Alumno alumno) {
		ClientResponse response = requester.getStudentAssignments();
		String json = response.getEntity(String.class);
		alumno.setAsignaciones(parserAsignaciones.jsonToObjectList(json, Asignacion.class));
	}
}