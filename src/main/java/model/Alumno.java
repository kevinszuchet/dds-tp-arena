package model;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

@Observable
public class Alumno {
	private String nombreYapellido;
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

	public void setNombreYapellido(String nombreYapellido) {
		this.nombreYapellido = nombreYapellido;
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public String getUsuarioGithub() {
		return usuarioGithub;
	}

	public void setUsuarioGithub(String usuarioGithub) {
		this.usuarioGithub = usuarioGithub;
	}
	
	public void agregarAsignacion(Asignacion asignacion) {
		asignaciones.add(asignacion);
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	
	public boolean meCorrespondeElLegajo(long legajo) {
		return this.legajo == legajo;
	}
}
