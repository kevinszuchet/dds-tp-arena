package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import model.asignaciones.Calificacion;
import model.asignaciones.CalificacionConceptual;
import model.asignaciones.CalificacionNumerica;

public class CalificacionDeserializer extends JsonDeserializer<Calificacion> {
	
	@Override
	public Calificacion deserialize(JsonParser jp, DeserializationContext context) throws IOException, JsonProcessingException {
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);
		
		Double calificacionNumerica = node.get("value").asDouble(0);
		String calificacionConceptual = node.get("value").asText(null);		
		
		Calificacion calificacion = (calificacionNumerica > 0 ? new CalificacionNumerica(calificacionNumerica) : new CalificacionConceptual(calificacionConceptual));	
		
		return calificacion;
	}
}
