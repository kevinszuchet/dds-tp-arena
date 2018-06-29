package model;

public class CalificacionNumerica implements Calificacion {
	private final int seApruebaCon = 6;
	private int valor;
	
	public CalificacionNumerica(int valor) {
		this.valor = valor;
	}
	
	public String getCalificacion() {
		return Integer.toString(valor);
	}
	
	public boolean calificacionAprobada() {
		return valor >= seApruebaCon;
	}
}
