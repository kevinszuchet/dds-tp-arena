package model;

import java.util.Arrays;

import model.repositories.Repositorios;

public class Fixture {

	public static void initialize() {
		Tarea unaTarea = new Tarea("Parcial dds");
		Tarea croc = new Tarea("Calculo Integral de Crocs II");
		Tarea kabalah = new Tarea("Ciencias de la kabalah");
		Tarea volver = new Tarea("Volve, pero clavate una de esas");
		Tarea llamada = new Tarea("Llamar cuando estudiamos");
		
		CalificacionNumerica uno = new CalificacionNumerica(1);
		CalificacionNumerica dos = new CalificacionNumerica(2);
		CalificacionNumerica tres = new CalificacionNumerica(3);
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
		Asignacion asignacionCroc = new Asignacion(croc, Arrays.asList(diez));
		Asignacion asignacionKabalah = new Asignacion(kabalah, Arrays.asList(mal, mal, regular));
		Asignacion asignacionVolver = new Asignacion(volver, Arrays.asList(uno, dos, cuatro));
		Asignacion asignacionLlamar = new Asignacion(llamada, Arrays.asList(diez, diez, diez));
		
		Repositorios.asignaciones.agregar(asignacionNumerica);
		Repositorios.asignaciones.agregar(asignacionConceptual);
		Repositorios.asignaciones.agregar(asignacionCroc);
		Repositorios.asignaciones.agregar(asignacionKabalah);
		Repositorios.asignaciones.agregar(asignacionVolver);
		Repositorios.asignaciones.agregar(asignacionLlamar);
		
		Alumno krane = new Alumno("Matias Kranevitter", 0);
		krane.agregarAsignacion(asignacionNumerica);
		krane.agregarAsignacion(asignacionConceptual);
		
		Alumno jorge = new Alumno("Jorge Supital", 1234);
		jorge.agregarAsignacion(asignacionCroc);
		
		Alumno natalio = new Alumno("Natalio Steiner", 90);
		natalio.agregarAsignacion(asignacionKabalah);
		
		Alumno saralegui = new Alumno("Saralegui", 90);
		saralegui.agregarAsignacion(asignacionVolver);
		
		Alumno leo = new Alumno("Leo NN", 12);
		leo.agregarAsignacion(asignacionLlamar);
		
		Repositorios.alumnos.agregar(krane);
		Repositorios.alumnos.agregar(jorge);
		Repositorios.alumnos.agregar(natalio);
		Repositorios.alumnos.agregar(saralegui);
		Repositorios.alumnos.agregar(leo);
	}
}
