import com.sun.jersey.api.client.ClientResponse;

import json.JSONParser;
import model.Alumno;
import services.ApiConnector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApiConnectorTest {

    private ApiConnector requester;
    private JSONParser<Alumno> parserAlumnos = new JSONParser<Alumno>();

    @Before
    public void setUp() throws Exception {
        this.requester = new ApiConnector();
    }

    @Test
    public void obtenerAlumno() {
        ClientResponse response = this.requester.getStudent();
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
    	ClientResponse response = this.requester.getStudentAssignments();
        assertEquals(response.getStatus(), 200);
        
        String json = response.getEntity(String.class);
        assertTrue(json.contains("assignments"));  
    }
}