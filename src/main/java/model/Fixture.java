package model;

import java.util.ArrayList;
import java.util.Arrays;

import model.repositories.Repositorios;

public class Fixture {

	public static void initialize() {
		Repositorios.alumnos.agregar(new Alumno("Matias Kranevitter", 0));
		Tarea unaTarea = new Tarea("Parcial", TipoCalificacionNumerica.getInstance());
		Repositorios.asignaciones.agregar(new Asignacion(), ));
	}
}
