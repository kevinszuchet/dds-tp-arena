package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Alumno;
import model.NoExisteLegajoIngresadoException;

public class AlumnosRepository {

	private List<Alumno> alumnos = new LinkedList<>();

	public void agregar(Alumno prenda) {
		this.alumnos.add(prenda);
	}

	public List<Alumno> all() {
		return alumnos;
	}

	public Alumno getXlegajo(long legajo) {
		return alumnos.stream().filter(alumno -> alumno.meCorrespondeElLegajo(legajo)).findFirst().orElseThrow(NoExisteLegajoIngresadoException::new);
	}
}
