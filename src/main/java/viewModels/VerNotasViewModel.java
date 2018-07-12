package viewModels;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Alumno;
import model.Asignacion;

@Observable
public class VerNotasViewModel {
	private Alumno alumno;
	
	public VerNotasViewModel(Alumno alumno) {
		super();
		this.alumno = alumno;
	}
	
	public List<Asignacion> getAsignaciones() {
		return alumno.getAsignaciones();
	}
	
	public String getNombreYApellido() {
		return alumno.getNombreYapellido();
	}
	
	public long getLegajo() {
		return alumno.getLegajo();
	}
	
	public String getUsuarioGithub() {
		return alumno.getUsuarioGithub();
	}
	
	public Alumno getAlumno() {		
		return alumno;
	}
}