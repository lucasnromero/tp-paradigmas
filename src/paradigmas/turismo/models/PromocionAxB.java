package paradigmas.turismo.models;

import java.util.List;

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
		return super.toString() + "-Duracion: " + super.getTiempoTotal() + "\n" + "-Precio original: " + super.getCostoTotal() + "\n"
				+ "-Precio con descuento: " + this.getCostoTotal();
	}

	@Override
	public int compareTo(final Promocion promocion) {
		
		int comparacionPrecio = Integer.compare(this.getCostoTotal(), promocion.getCostoTotal());

		if (comparacionPrecio != 0)
			return comparacionPrecio;

		return Double.compare(super.getTiempoTotal(), promocion.getTiempoTotal());
		
	}

}
