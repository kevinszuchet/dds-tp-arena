import com.sun.jersey.api.client.ClientResponse;
import java.util.List;

import json.JSONParser;
import model.Alumno;
import model.asignaciones.Asignacion;
import service.ApiConnector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApiConnectorTest {

    private ApiConnector requester;
    private JSONParser<Alumno> parserAlumnos = new JSONParser<Alumno>();
    private JSONParser<Asignacion> parserAsignaciones = new JSONParser<Asignacion>();
    
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    @Before
    public void setUp() throws Exception {
        this.requester = new ApiConnector();
    }

    @Test
    public void obtenerAlumno() {
        ClientResponse response = this.requester.getStudentByToken(token);
        assertEquals(response.getStatus(), 200);
        
        String json = response.getEntity(String.class);
        // Contiene el código 111222333
        assertTrue(json.contains("111222333"));
        
        Alumno alumno = parserAlumnos.jsonToObject(json, Alumno.class);
        assertEquals(alumno.getLegajo(), 111222333);
    }

    /*@Test
    public void modificoUnAlumno() {
    	Alumno krane = new Alumno("Matias", "Kranevitter", 111222333, "kranevictor"); 
        ClientResponse response = this.requester.updateStudentByToken(token, krane);
        System.out.println(response);
        assertEquals(response.getStatus(), 201);
        
        String json = response.getEntity(String.class);        
        Alumno alumno = parserAlumnos.jsonToObject(json, Alumno.class);
        assertEquals(alumno.getUsuarioGithub(), "kranevictor");
    }*/

    @Test
    public void obtenerAsignaciones() {
    	ClientResponse response = this.requester.getStudentAssignmentsByToken(token);
        assertEquals(response.getStatus(), 200);
        
        String json = response.getEntity(String.class);
        assertTrue(json.contains("assignments"));
        
        List<Asignacion> asignaciones = parserAsignaciones.jsonToObjectList(json, Asignacion.class);
        assertEquals(asignaciones.size(), 2);
    }
}