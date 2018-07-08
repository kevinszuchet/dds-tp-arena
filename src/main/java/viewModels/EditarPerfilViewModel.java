package viewModels;

import org.uqbar.commons.utils.Observable;

import model.Alumno;

@Observable
public class EditarPerfilViewModel {
	private Alumno alumno;
	
	private String nombreYApellido;
	private long legajo;
	private String usuarioGithub;
	
	public EditarPerfilViewModel(Alumno alumno) {
		super();
		this.alumno = alumno;
	}
	
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
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
		alumno.setNombreYapellido(nombreYApellido).setLegajo(legajo).setUsuarioGithub(usuarioGithub);
	}
}
