package viewModels;

import java.util.List;
import java.util.ArrayList;

import org.uqbar.commons.utils.Observable;

import model.Alumno;
import model.Asignacion;
import model.Calificacion;
import model.NoExisteLegajoIngresadoException;
import model.Tarea;
import model.repositories.Repositorios;

@Observable
public class VerNotasViewModel {
	
	private List<Asignacion> asignaciones = new ArrayList<>();
	private long legajo;
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public void cargarAsignaciones() {
		Alumno alumno = this.getAlumnoConLegajo();
		alumno.agregarAsignacion(new Asignacion(new Tarea(), new ArrayList<Calificacion>()));
		this.setAsignaciones(alumno.getAsignaciones());
	}	
	
	public Alumno getAlumnoConLegajo() {
		Repositorios.alumnos.all().add(new Alumno("Matias Kranevitter", 12345678));
		return Repositorios.alumnos.all().stream().filter(
				alumno -> alumno.meCorrespondeElLegajo(legajo)
		).findFirst().orElseThrow(NoExisteLegajoIngresadoException::new);
	}
}
