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

import model.Calificacion;

public class JSONParser<Entidad> {		 
	
	ObjectMapper mapper = new ObjectMapper().registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
	
	public Entidad jsonToObject(String json, Class<Entidad> tipoEntidad) {
		
		Entidad elemento;
		
		try {
			elemento = mapper.readValue(json, tipoEntidad);
		} catch (NoSePudoImportarJSONException e) {
			throw new NoSePudoImportarJSONException();
		} catch (JsonMappingException e) {
			throw new NoSePudoImportarJSONException();
		} catch (IOException e) {
			throw new NoSePudoImportarJSONException();
		}
		
		return elemento;
	}
	
	public List<Entidad> jsonToObjectList(String json, Class<Entidad> tipoEntidad) {
		
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
	
	public String objectToJson(Entidad entidad) {

		String json = ""; 
		
		try {
			json = mapper.writeValueAsString(entidad);
		} catch (JsonParseException e) {
			throw new NoSePudoImportarJSONException();
		} catch (JsonMappingException e) {
			throw new NoSePudoImportarJSONException();
		} catch (IOException e) {
			throw new NoSePudoImportarJSONException();
		}
		
		return json;
	}

}