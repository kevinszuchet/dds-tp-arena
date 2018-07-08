package viewModels;

import org.uqbar.commons.utils.Observable;

import model.Alumno;
import model.repositories.Repositorios;

@Observable
public class IndexViewModel {
	
	long legajo;

	public IndexViewModel() {
		super();
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}
	
	public Alumno getAlumnoXlegajo() {
		return Repositorios.alumnos.getXlegajo(legajo);
	}
}
