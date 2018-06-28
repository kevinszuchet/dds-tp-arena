package model.repositories;

import java.util.LinkedList;
import java.util.List;

import model.Alumno;

public class AlumnosRepository {

	private List<Alumno> prendas = new LinkedList<>();

	public void agregar(Alumno prenda) {
		this.prendas.add(prenda);
	}

	public List<Alumno> all() {
		return prendas;
	}

}
