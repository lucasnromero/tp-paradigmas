package paradigmas.turismo.models;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(atraccionPreferida, other.atraccionPreferida)
				&& Objects.equals(nombreUsuario, other.nombreUsuario) && presupuesto == other.presupuesto
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible);
	}



	public void compraAtraccion(final int dinero, final double tiempoDisponible) {
		this.presupuesto -= dinero;
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

	public void mostrarUsuarioInicio() {
		System.out.println("\u001B[1mUSUARIO:\u001B[0m " + this.getNombreUsuario() + "\n"
				+ "\u001B[1mTiempo disponible:\u001B[0m " + this.getTiempoDisponible() + "\n"
				+ "\u001B[1mPresupuesto:\u001B[0m " + this.getPresupuesto() + "\n"
				+ "\u001B[1mTipo de atracciones preferidas:\u001B[0m " + this.getAtraccionPreferida() + "\n");

		System.out.println("\n*****************************************");
		System.out.println("\u001B[1mSUGERENCIAS DE COMPRA\u001B[0m");
	}

}
