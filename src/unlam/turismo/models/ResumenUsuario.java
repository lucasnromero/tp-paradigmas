package unlam.turismo.models;

import unlam.turismo.sugerencia.Sugerencia;

public class ResumenUsuario {

	private int monedasGastadas;
	private double tiempoInvertido;
	private Sugerencia sugerenciasAceptadas;

	public ResumenUsuario() {

		this.monedasGastadas = 0;
		this.tiempoInvertido = 0;
		this.sugerenciasAceptadas = null;
	}

	public int getMonedasGastadas() {
		return monedasGastadas;
	}

	public void setMonedasGastadas(int monedasGastadas) {
		this.monedasGastadas += monedasGastadas;
	}

	public double getTiempoInvertido() {
		return tiempoInvertido;
	}

	public void setTiempoInvertido(double tiempoInvertido) {
		this.tiempoInvertido += tiempoInvertido;
	}

	public Sugerencia getSugerenciasAceptadas() {
		return sugerenciasAceptadas;
	}

}
