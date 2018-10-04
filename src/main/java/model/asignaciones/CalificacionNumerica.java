package model.asignaciones;

public class CalificacionNumerica implements Calificacion {
	private final double seApruebaCon = 6;
	private double valor;
	
	public CalificacionNumerica(int valor) {
		this.valor = valor;
	}
	
	public String getCalificacion() {
		return Double.toString(valor);
	}
	
	public boolean estaAprobada() {
		return valor >= seApruebaCon;
	}
}
