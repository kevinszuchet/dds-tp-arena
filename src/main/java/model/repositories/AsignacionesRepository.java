package model.repositories;

import java.util.ArrayList;
import java.util.List;

import model.Asignacion;

public class AsignacionesRepository {

	private List<Asignacion> asignaciones = new ArrayList<>();

	public List<Asignacion> all() {
		return this.asignaciones;
	}

}
