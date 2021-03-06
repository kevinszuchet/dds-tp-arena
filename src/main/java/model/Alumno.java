package model;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.repositories.AlumnosRepository;

@JsonIgnoreProperties(ignoreUnknown = true)
@Observable
public class Alumno {
	
	@JsonProperty("code")
	private long legajo;
	
	@JsonProperty("first_name")
	public String nombre;
	
	@JsonProperty("last_name")
	public String apellido;
	
	@JsonProperty("github_user")
	private String usuarioGithub;
	
	@JsonIgnore
	private List<Asignacion> asignaciones = new ArrayList<>();
	
	public Alumno() {}

	public Alumno(String nombre, String apellido, long legajo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
	}
	
	public Alumno(String nombre, String apellido, long legajo, String usuarioGithub) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.usuarioGithub = usuarioGithub;
	}
	
	@JsonIgnore
	public String getNombreYApellido() {
		return nombre + " " + apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Alumno setNombreYapellido(String nombreYapellido) {
		this.nombre = nombreYapellido;
		return this;
	}

	public long getLegajo() {
		return legajo;
	}

	public Alumno setLegajo(long legajo) {
		this.legajo = legajo;
		return this;
	}

	public String getUsuarioGithub() {
		return usuarioGithub;
	}

	public Alumno setUsuarioGithub(String usuarioGithub) {
		this.usuarioGithub = usuarioGithub;
		return this;
	}
	
	public void agregarAsignacion(Asignacion asignacion) {
		asignaciones.add(asignacion);
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	
	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;		
	}
	
	public boolean meCorrespondeElLegajo(long legajo) {
		return this.legajo == legajo;
	}

	public void modificarPerfil(String nombre, String apellido, String usuarioGithub) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuarioGithub = usuarioGithub;
		
		AlumnosRepository.getInstance().modificar(this);
	}
}
