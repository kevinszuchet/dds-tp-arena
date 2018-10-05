package json;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class JSONParser<Entidad> {		 
	
	ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
	
	public Entidad jsonToObject(String json, Class<Entidad> tipoEntidad) {
		
		Entidad elemento = null;
		
		try {
			elemento = mapper.readValue(json, tipoEntidad);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return elemento;
	}
	
	// TODO: habria que revisar porque no se puede parsear las asignaciones con esto	
	/*public List<Entidad> jsonToObjectList(String json, Class<Entidad> tipoEntidad) {
		
		List<Entidad> elementos = new ArrayList<>();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
		try {
			elementos = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(ArrayList.class, tipoEntidad));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return elementos;
	}*/
	
	public String objectToJson(Entidad entidad) {

		String json = ""; 
		
		try {
			json = mapper.writeValueAsString(entidad);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}
}