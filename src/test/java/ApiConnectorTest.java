import com.sun.jersey.api.client.ClientResponse;

import json.JSONParser;
import model.Alumno;
import model.ApiConnector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApiConnectorTest {

    ApiConnector requester;
    JSONParser<Alumno> parserAlumnos = new JSONParser<Alumno>();

    @Before
    public void setUp() throws Exception {
        this.requester = new ApiConnector();
    }

    @Test
    public void obtenerXtoken() {
        ClientResponse response = this.requester.getStudentByToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho");
        assertEquals(response.getStatus(), 200);
        
        String json = response.getEntity(String.class);
        // Contiene el código 111222333
        assertTrue(json.contains("111222333"));
        
        Alumno alumno = parserAlumnos.jsonToObject(json, Alumno.class);
        assertEquals(alumno.getLegajo(), 111222333);
    }

    @Test
    public void modificoUnAlumno() {
    	Alumno krane = new Alumno("Matias", "Kranevitter", 111222333, "kranevictor"); 
        ClientResponse response = this.requester.updateStudentByToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho", krane);
        System.out.println(response);
        assertEquals(response.getStatus(), 201);
        
        String json = response.getEntity(String.class);        
        Alumno alumno = parserAlumnos.jsonToObject(json, Alumno.class);
        assertEquals(alumno.getUsuarioGithub(), "kranevictor");
    }
}