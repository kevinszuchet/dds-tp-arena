package model;

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

public class CalificacionConceptual implements Calificacion { 
	private ValorConceptual valor;
	
	public CalificacionConceptual(ValorConceptual valor) {
		this.valor = valor;
	}
	
	public String getCalificacion() {
		return valor.toString();		
	}
	
	public ValorConceptual getValor() {
		return valor;
	}
}