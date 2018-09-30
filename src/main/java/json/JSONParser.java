package json;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class JSONParser<Entidad> {		 
	
	public List<Entidad> parsear(String json, Class<Entidad> tipoEntidad) {
		
		ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
		List<Entidad> elementos = new ArrayList<>();
		
		try {
			elementos = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(ArrayList.class, tipoEntidad));
		} catch (JsonParseException e) {
			throw new NoSePudoImportarJSONException();
		} catch (JsonMappingException e) {
			throw new NoSePudoImportarJSONException();
		} catch (IOException e) {
			throw new NoSePudoImportarJSONException();
		}
		
		return elementos;
	}
}