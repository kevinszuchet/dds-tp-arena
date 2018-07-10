package model.repositories;

import java.util.ArrayList;
import java.util.List;

import model.Alumno;
import model.Asignacion;

public class AsignacionesRepository {

	private List<Asignacion> asignaciones = new ArrayList<>();

	public void agregar(Asignacion asignacion) {
		this.asignaciones.add(asignacion);
	}

	public List<Asignacion> all() {
		return this.asignaciones;
	}

}
