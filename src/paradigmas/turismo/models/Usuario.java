package paradigmas.turismo.models;

public class Usuario {

	private String nombreUsuario;
	private double tiempoDisponible;
	private int presupuesto;
	private String atraccionPreferida;

	public Usuario(final String nombreUsuario, final double tiempoDisponible, final int presupuesto,
			final String atraccionPreferida) {

		super();

		this.tiempoDisponible = tiempoDisponible;
		this.presupuesto = presupuesto;
		this.atraccionPreferida = atraccionPreferida;
		this.nombreUsuario = nombreUsuario;
	}

	public void disminuirDinero(final int dinero) {
		this.presupuesto -= dinero;
	}

	public void disminuirTiempoDisponible(final double tiempoDisponible) {
		this.tiempoDisponible -= tiempoDisponible;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public double getTiempoDisponible() {
		return this.tiempoDisponible;
	}

	public int getPresupuesto() {
		return this.presupuesto;
	}

	public String getAtraccionPreferida() {
		return this.atraccionPreferida;
	}

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", tiempoDisponible=" + tiempoDisponible + ", presupuesto="
				+ presupuesto + ", atraccionPreferida=" + atraccionPreferida + "]";
	}

}
