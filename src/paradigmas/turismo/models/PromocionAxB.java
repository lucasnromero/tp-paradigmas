package paradigmas.turismo.models;

import java.util.List;
import java.util.Objects;

public class PromocionAxB extends Promocion {

	private Atraccion atraccionGratuita;

	public PromocionAxB(final List<Atraccion> listaAtracciones, final Atraccion atraccionGratuita) {

		super(listaAtracciones);

		this.atraccionGratuita = atraccionGratuita;
	}

	@Override
	public int getCostoTotal() {
		return super.getCostoTotal() - this.atraccionGratuita.getCostoVisita();
	}

	@Override
	public String toString() {
		return super.toString() + "-Duracion: " + super.getTiempoTotal() + "\n" + "-Precio original: "
				+ super.getCostoTotal() + "\n" + "-Precio promocional: " + this.getCostoTotal() + "¡La atracción "
				+ this.getAtraccionGratuita().getNombreAtraccion() + " es gratis!";
	}

	public String toStringUI() {
		return super.toStringUI() + "\u2022 Duración: " + super.getTiempoTotal() + " horas" + "\n"
				+ "\u2022 Precio original: " + super.getCostoTotal() + "\n" + "\u2022 Precio promocional: "
				+ this.getCostoTotal() + "\n" + "¡La atracción " + this.getAtraccionGratuita().getNombreAtraccion()
				+ " es gratis!";
	}

	@Override
	public int compareTo(final Promocion promocion) {

		int comparacionPrecio = Integer.compare(this.getCostoTotal(), promocion.getCostoTotal());

		if (comparacionPrecio != 0)
			return comparacionPrecio;

		return Double.compare(super.getTiempoTotal(), promocion.getTiempoTotal());

	}

	public Atraccion getAtraccionGratuita() {
		return this.atraccionGratuita;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromocionAxB other = (PromocionAxB) obj;
		return Objects.equals(atraccionGratuita, other.atraccionGratuita);
	}

}
