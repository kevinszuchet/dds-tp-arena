package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TipoCalificacionConceptual implements TipoCalificacion<CalificacionConceptual> {
	final List<ValorConceptual> conceptosAprobables = new ArrayList<>(Arrays.asList(ValorConceptual.BIEN, ValorConceptual.MUY_BIEN));
	
	public boolean calificacionesAprobadas(List<CalificacionConceptual> calificaciones) {
		return calificaciones.stream().allMatch(calificacion -> this.calificacionAprobada(calificacion));
	}
	
	public boolean calificacionAprobada(CalificacionConceptual calificacion) {
		return conceptosAprobables.contains(calificacion.getValor());
	}
}
