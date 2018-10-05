import static org.junit.Assert.assertEquals;

import org.junit.Test;

import json.JSONParser;
import model.Alumno;

public class JSONParserTest {

    @Test
    public void ParseoJsonDeAsignaciones() {
    	JSONParser<Alumno> parserAlumnos = new JSONParser<Alumno>();        
        String json = "{\"assignments\": [{\"id\": 1, \"title\": \"Primer Parcial\", \"description\": null, \"grades\": [{\"id\": 1, \"value\": 2, \"created_at\": \"2017-03-25T13:56:07.526Z\", \"updated_at\": \"2017-03-25T13:56:07.526Z\"}, {\"id\": 2, \"value\": 7, \"created_at\": \"2017-03-25T13:56:07.595Z\", \"updated_at\": \"2017-03-25T13:56:07.595Z\"} ] }, {\"id\": 3, \"title\": \"TPA1\", \"description\": \"Primera Entrega del TP Anual\", \"grades\": [{\"id\": 4, \"value\": \"BIEN\", \"created_at\": \"2017-03-25T13:56:07.649Z\", \"updated_at\": \"2017-03-25T13:56:07.649Z\"} ] } ] }";
        
        Alumno alumnoConAsignaciones = parserAlumnos.jsonToObject(json, Alumno.class);
        
        assertEquals(alumnoConAsignaciones.getAsignaciones().size(), 2);
        
        /*for (Asignacion asignacion : alumnoConAsignaciones.getAsignaciones()) {        	
        	System.out.println(asignacion.getTarea().getNombre());
        	System.out.println(asignacion.getTarea().getDescripcion());
        	
        	for (Calificacion calificacion : asignacion.getCalificaciones()) {            	
            	System.out.println(calificacion.getCalificacion());
        	}
        }*/        
    }

}
