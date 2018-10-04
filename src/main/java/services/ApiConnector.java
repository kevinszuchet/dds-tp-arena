package services;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import json.JSONParser;
import model.Alumno;

import javax.ws.rs.core.MediaType;
public class ApiConnector {

	
	private Client client;
    private static final String API_DDS = "http://notitas.herokuapp.com";
    private static final String STUDENT_RESOURCE = "/student";
    private static final String ASSIGNMENTS_RESOURCE = "/assignments";
	
	private static final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    // Inicializacion del cliente.
    public ApiConnector() {
        this.client = Client.create();
        //En la documentacion se puede ver como al cliente agregarle un ClientConfig
        //para agregarle filtros en las respuestas (por ejemplo, para loguear).
    }
    
    public ClientResponse getStudent() {    	
    	return this.client.resource(API_DDS)
				.path(STUDENT_RESOURCE)
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
    }
    
    public ClientResponse updateStudent(Alumno alumno) {
    	JSONParser<Alumno> parser = new JSONParser<Alumno>();
    	
    	return this.client.resource(API_DDS)
				.path(STUDENT_RESOURCE)
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, parser.objectToJson(alumno));
    }
    
    public ClientResponse getStudentAssignments() {    	
    	return this.client.resource(API_DDS)
				.path(STUDENT_RESOURCE).path(ASSIGNMENTS_RESOURCE)
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
    }
}
