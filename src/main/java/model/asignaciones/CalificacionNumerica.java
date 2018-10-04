package model.asignaciones;

public class CalificacionNumerica extends Calificacion {
	private final double seApruebaCon = 6;
	private double valor;
	
	public CalificacionNumerica(double valor) {
		this.valor = valor;
	}
	
	public String getCalificacion() {
		return Double.toString(valor);
	}
	
	public boolean estaAprobada() {
		return valor >= seApruebaCon;
	}
}
