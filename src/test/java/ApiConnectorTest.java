import com.sun.jersey.api.client.ClientResponse;

import json.JSONParser;
import model.Alumno;
import model.asignaciones.Asignacion;
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
        
        json = "{\"assignments\": [{\"id\": 1, \"title\": \"Primer Parcial\", \"description\": null, \"grades\": [{\"id\": 1, \"value\": 2, \"created_at\": \"2017-03-25T13:56:07.526Z\", \"updated_at\": \"2017-03-25T13:56:07.526Z\"}, {\"id\": 2, \"value\": 7, \"created_at\": \"2017-03-25T13:56:07.595Z\", \"updated_at\": \"2017-03-25T13:56:07.595Z\"} ] }, {\"id\": 3, \"title\": \"TPA1\", \"description\": \"Primera Entrega del TP Anual\", \"grades\": [{\"id\": 4, \"value\": \"B+\", \"created_at\": \"2017-03-25T13:56:07.649Z\", \"updated_at\": \"2017-03-25T13:56:07.649Z\"} ] } ] }";
        JSONParser<Asignacion> asignacionParser = new JSONParser<Asignacion>();
        
        Alumno alumno = new Alumno();
        alumno.setAsignaciones(asignacionParser.jsonToObjectList(json, Asignacion.class));
        
        for (Asignacion asignacion : alumno.getAsignaciones()) {        	
        	System.out.println(asignacion.getTarea().getNombre());
        	System.out.println(asignacion.getTarea().getDescripcion());
        }        
    }
}