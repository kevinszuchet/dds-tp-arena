package model.asignaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum ValorConceptual {
	MAL, 
	REGULAR, 
	BIEN, 
	MUY_BIEN;
	
	public String toString() {
        return firstToUpper(super.toString().replace("_", " "));
    }

	private String firstToUpper(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}

public class CalificacionConceptual extends Calificacion { 
	final List<ValorConceptual> conceptosAprobables = new ArrayList<>(Arrays.asList(ValorConceptual.BIEN, ValorConceptual.MUY_BIEN));
	private ValorConceptual valor;
	
	public CalificacionConceptual(ValorConceptual valor) {
		this.valor = valor;
	}
	
	public CalificacionConceptual(String valor) {
		this.valor = ValorConceptual.valueOf(valor);
	}
	
	public String getCalificacion() {
		return valor.toString();		
	}

	@Override
	public boolean estaAprobada() {
		return conceptosAprobables.contains(valor);
	}
}