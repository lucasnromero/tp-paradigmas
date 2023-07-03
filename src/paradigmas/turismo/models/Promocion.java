package paradigmas.turismo.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Promocion implements Comparable<Promocion> {

	private List<Atraccion> listaAtracciones;

	public Promocion(final List<Atraccion> listaAtracciones) {

		super();

		this.listaAtracciones = listaAtracciones;
	}

	public int getCostoTotal() {

		int costoTotal = 0;

		for (Atraccion atraccion : this.listaAtracciones)
			costoTotal += atraccion.getCostoVisita();

		return costoTotal;
	}

	public double getTiempoTotal() {

		double tiempoTotal = 0;

		for (Atraccion atraccion : this.listaAtracciones)
			tiempoTotal += atraccion.getPromedioDeTiempo();

		return tiempoTotal;
	}


	public String getTipoAtracciones() {
		return this.listaAtracciones.get(0).getTipoAtraccion();
	}

	public List<Atraccion> getAtracciones() {
		return this.listaAtracciones;
	}

	@Override
	public String toString() {
		return "Promoción " + this.getTipoAtracciones() + "\n" + "-Atracciones incluídas: "
				+ Arrays.toString(this.getNombresAtracciones()) + "\n";
	}

	public String toStringUI() {
		return "\u001B[1mPromoción\u001B[0m " + this.getTipoAtracciones() + "\n" + "\u2022 Atracciones incluídas: "
				+ Arrays.toString(this.getNombresAtracciones()) + "\n";
	}

	private String[] getNombresAtracciones() {

		String[] nombresAtracciones = new String[this.listaAtracciones.size()];
		int i = 0;

		for (Atraccion atraccion : this.listaAtracciones) {
			nombresAtracciones[i] = atraccion.getNombreAtraccion();
			i++;
		}

		return nombresAtracciones;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(listaAtracciones, other.listaAtracciones);
	}

}
