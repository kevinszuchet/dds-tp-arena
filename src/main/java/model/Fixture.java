package model;

import java.util.Arrays;

import model.repositories.Repositorios;

public class Fixture {

	public static void initialize() {
		Tarea unaTarea = new Tarea("Parcial dds");
		
		CalificacionNumerica cuatro = new CalificacionNumerica(4);
		CalificacionNumerica cinco = new CalificacionNumerica(5);
		CalificacionNumerica seis = new CalificacionNumerica(6);
		CalificacionNumerica siete = new CalificacionNumerica(7);
		CalificacionNumerica ocho = new CalificacionNumerica(8);
		CalificacionNumerica nueve = new CalificacionNumerica(9);
		CalificacionNumerica diez = new CalificacionNumerica(10);
		
		CalificacionConceptual mal = new CalificacionConceptual(ValorConceptual.MAL);
		CalificacionConceptual regular = new CalificacionConceptual(ValorConceptual.REGULAR);
		CalificacionConceptual bien = new CalificacionConceptual(ValorConceptual.BIEN);
		CalificacionConceptual mb = new CalificacionConceptual(ValorConceptual.MUY_BIEN);
		
		Asignacion asignacionNumerica = new Asignacion(unaTarea, Arrays.asList(seis, ocho, diez));
		Asignacion asignacionConceptual = new Asignacion(unaTarea, Arrays.asList(mal, regular, bien, mb));
		
		Repositorios.asignaciones.agregar(asignacionNumerica);
		Repositorios.asignaciones.agregar(asignacionConceptual);
		
		Alumno krane = new Alumno("Matias Kranevitter", 0);
		krane.agregarAsignacion(asignacionNumerica);
		krane.agregarAsignacion(asignacionConceptual);
		
		Repositorios.alumnos.agregar(krane);
	}
}
