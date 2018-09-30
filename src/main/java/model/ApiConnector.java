package model;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
public class ApiConnector {

	
	private Client client;
    private static final String API_DDS = "http://notitas.herokuapp.com";
    private static final String STUDENTRESOURCE = "/student";
    private static final String ASSIGNMENTSRESOURCE = "/assignments";

    //Inicializacion del cliente.
    public ApiConnector() {
        this.client = Client.create();
        //En la documentacion se puede ver como al cliente agregarle un ClientConfig
        //para agregarle filtros en las respuestas (por ejemplo, para loguear).
    }
    
//    public ClientResponse getGenericResponse (List<String> resources, String token){
//    	
//    	ClientResponse  response = this.client.resource(API_DDS)
//				.path(String.join("", resources))
//				.header("Authorization", "Bearer" + token)
//				.accept(MediaType.APPLICATION_JSON)
//				.get(ClientResponse.class);
//
//		return response;
//    }
//    
//    public ClientResponse getStudentByToken2 (String token) {
//    	
//    	return this.getGenericResponse(Arrays.asList(STUDENTRESOURCE), token);
//    }
//    
//    public ClientResponse getStudentAssignmentsByToken2 (String token) {
//    	
//    	return this.getGenericResponse(Arrays.asList(STUDENTRESOURCE, ASSIGNMENTSRESOURCE), token);
//    }
    
    public ClientResponse getStudentByToken (String token) {
    	
    	ClientResponse  response = this.client.resource(API_DDS)
    								.path(STUDENTRESOURCE)
    								.header("Authorization", "Bearer" + token)
                					.accept(MediaType.APPLICATION_JSON)
                					.get(ClientResponse.class);
    	
        return response;
    }
    
    public ClientResponse getStudentAssignmentsByToken (String token) {
    	
    	ClientResponse  response = this.client.resource(API_DDS)
    								.path(STUDENTRESOURCE).path(ASSIGNMENTSRESOURCE)
    								.header("Authorization", "Bearer" + token)
                					.accept(MediaType.APPLICATION_JSON)
                					.get(ClientResponse.class);
    	
        return response;
    }
}
