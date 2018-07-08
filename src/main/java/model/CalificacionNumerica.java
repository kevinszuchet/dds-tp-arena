package model;

public class CalificacionNumerica implements Calificacion {
	private int valor;
	
	public CalificacionNumerica(int valor) {
		this.valor = valor;
	}
	
	public String getCalificacion() {
		return Integer.toString(valor);
	}
	
	public int getValor() {
		return valor;
	}
}
