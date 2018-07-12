package model;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

@Observable
public class Alumno {
	public String nombreYapellido;
	private long legajo;
	private String usuarioGithub;
	private List<Asignacion> asignaciones = new ArrayList<>();

	public Alumno(String nombreYapellido, long legajo) {
		super();
		this.nombreYapellido = nombreYapellido;
		this.legajo = legajo;
	}

	public String getNombreYapellido() {
		return nombreYapellido;
	}

	public Alumno setNombreYapellido(String nombreYapellido) {
		this.nombreYapellido = nombreYapellido;
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
}
