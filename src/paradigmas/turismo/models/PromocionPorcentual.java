package paradigmas.turismo.models;

import java.util.List;
import java.util.Objects;

public class PromocionPorcentual extends Promocion {

	private double descuento;

	public PromocionPorcentual(final List<Atraccion> listaAtracciones, final double descuento) {

		super(listaAtracciones);

		this.descuento = descuento;
	}

	@Override
	public int getCostoTotal() {

		int costoTotal = super.getCostoTotal();

		return (int) (costoTotal * (100.0 - this.descuento) / 100.0);
	}

	@Override
	public String toString() {
		return super.toString() + "-Duracion: " + super.getTiempoTotal() + "\n" + "-Precio original: "
				+ super.getCostoTotal() + "\n" + "-Precio con descuento: " + this.getCostoTotal();
	}

	public String toStringUI() {
		return super.toStringUI() + "\u2022 Duración: " + super.getTiempoTotal() + "\n" + "\u2022 Precio original: "
				+ super.getCostoTotal() + "\n" + "\u2022 Precio con descuento: " + this.getCostoTotal();
	}

	@Override
	public int compareTo(final Promocion promocion) {

		int comparacionPrecio = Integer.compare(this.getCostoTotal(), promocion.getCostoTotal());

		if (comparacionPrecio != 0)
			return comparacionPrecio;

		return Double.compare(super.getTiempoTotal(), promocion.getTiempoTotal());

	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromocionPorcentual other = (PromocionPorcentual) obj;
		return Double.doubleToLongBits(descuento) == Double.doubleToLongBits(other.descuento);
	}

}
