package viewModels;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Alumno;
import model.repositories.Repositorios;

@Observable
public class VerNotasViewModel {

	private List<Alumno> alumnos;
	private Alumno alumnoSeleccionado;

	public VerNotasViewModel() {
		this.alumnos = Repositorios.alumnos.all();
	}
	
	public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
		this.alumnoSeleccionado = alumnoSeleccionado;
	}
	
	public Alumno getAlumnoSeleccionado() {
		return alumnoSeleccionado;
	}
	
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
}
