package json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import model.asignaciones.Calificacion;

@SuppressWarnings("serial")
public class CalificacionDeserializer extends StdDeserializer<Calificacion> {

	public CalificacionDeserializer() {
		this(null);
	}
 
    public CalificacionDeserializer(Class<?> vc) {
        super(vc);
    }

	@Override
	public Calificacion deserialize(JsonParser jp, DeserializationContext context)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}
}
