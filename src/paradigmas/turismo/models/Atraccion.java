package paradigmas.turismo.models;

import java.util.Objects;

public class Atraccion implements Comparable<Atraccion> {

	private String nombreAtraccion;
	private int costoVisita;
	private double promedioDeTiempo;
	private int cupo;
	private String tipoAtraccion;

	public Atraccion(final String nombreAtraccion, final int costoVisita, final double promedioDeTiempo, final int cupo,
			final String tipoAtraccion) {

		super();

		this.nombreAtraccion = nombreAtraccion;
		this.costoVisita = costoVisita;
		this.promedioDeTiempo = promedioDeTiempo;
		this.cupo = cupo;
		this.tipoAtraccion = tipoAtraccion;
	}

	public String getNombreAtraccion() {
		return this.nombreAtraccion;
	}

	public int getCostoVisita() {
		return this.costoVisita;
	}

	public double getPromedioDeTiempo() {
		return this.promedioDeTiempo;
	}

	public int getCupo() {
		return this.cupo;
	}

	public String getTipoAtraccion() {
		return this.tipoAtraccion;
	}

	public void reducirCupo() {
		this.cupo--;
	}

	@Override
	public String toString() {
		return "Atraccion" + "\n" + "Nombre: " + this.nombreAtraccion + "\n" + "Precio: " + this.costoVisita + "\n"
				+ "Duracion: " + this.promedioDeTiempo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(costoVisita, nombreAtraccion, promedioDeTiempo, tipoAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costoVisita == other.costoVisita && Objects.equals(nombreAtraccion, other.nombreAtraccion)
				&& Double.doubleToLongBits(promedioDeTiempo) == Double.doubleToLongBits(other.promedioDeTiempo)
				&& Objects.equals(tipoAtraccion, other.tipoAtraccion);
	}

	@Override
	public int compareTo(final Atraccion atraccion) {

		int comparacionPrecio = Integer.compare(this.costoVisita, atraccion.costoVisita);

		if (comparacionPrecio != 0)
			return comparacionPrecio;

		return Double.compare(this.promedioDeTiempo, atraccion.promedioDeTiempo);
	}
}
