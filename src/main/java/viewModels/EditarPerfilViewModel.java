package viewModels;

import org.uqbar.commons.utils.Observable;

import model.Alumno;

@Observable
public class EditarPerfilViewModel {
	private Alumno alumno;
	
	private String nombre;
	private String apellido;
	private long legajo;
	private String usuarioGithub;
	
	public EditarPerfilViewModel(Alumno alumno) {
		super();
		this.alumno = alumno;
		
		this.nombre = alumno.getNombre();
		this.apellido = alumno.getApellido();
		this.legajo = alumno.getLegajo();
		this.usuarioGithub = alumno.getUsuarioGithub();
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
	
	public void modificarPerfil() {
		alumno.modificarPerfil(nombre, apellido, getUsuarioGithub());
	}
}