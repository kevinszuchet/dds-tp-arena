package viewModels;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

import model.Alumno;
import model.Asignacion;
import model.Calificacion;
import model.Tarea;

@Observable
public class VerNotasViewModel {
	
	private List<Asignacion> asignaciones = new ArrayList<>();
	private Alumno alumno;
	
	public VerNotasViewModel(Alumno alumno) {
		super();
		this.alumno = alumno;
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}
	
	public void cargarAsignaciones() {
		alumno.agregarAsignacion(new Asignacion(new Tarea(), new ArrayList<Calificacion>()));
		this.setAsignaciones(alumno.getAsignaciones());
	}
}