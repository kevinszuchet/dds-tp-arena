package viewModels;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Alumno;
import model.Asignacion;
import model.repositories.AsignacionesRepository;

@Observable
public class VerNotasViewModel {
	private Alumno alumno;
	
	public VerNotasViewModel(Alumno alumno) {
		super();
		this.alumno = alumno;
	}
	
	public List<Asignacion> getAsignaciones() {
		// TODO: cuando solucionemos el parseo del json de asignaciones descomentar el return
		return this.alumno.getAsignaciones();
		// return AsignacionesRepository.getInstance().obtenerXalumno(this.alumno);
	}
	
	public String getNombreYApellido() {
		return alumno.getNombreYApellido();
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
	
	public void actualizar() {
		
	}
}