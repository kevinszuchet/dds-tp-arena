package viewModels;

public class EditarPerfilViewModel {
	private String nombreYApellido;
	private long legajo;
	private String usuarioGithub;
	
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
		// TODO habria que obtener el alumno -> por legajo? y modificar los datos
	}
}
