package paradigmas.turismo.models;

import java.util.List;
import java.util.Objects;

public class PromocionAbsoluta extends Promocion {

	private int precioAbsoluto;

	public PromocionAbsoluta(final List<Atraccion> listaAtracciones, int menosPrecio) {

		super(listaAtracciones);

		this.precioAbsoluto = super.getCostoTotal() - menosPrecio;
	}

	@Override
	public int getCostoTotal() {
		return this.precioAbsoluto;
	}

	@Override
	public String toString() {
		return super.toString() + "-Duracion: " + super.getTiempoTotal() + "\n" + "-Precio original: "
				+ super.getCostoTotal() + "\n" + "-Precio con descuento: " + this.getCostoTotal();
	}

	public String toStringUI() {
		return super.toStringUI() + "\u2022 Duración: " + super.getTiempoTotal() + " horas" + "\n"
				+ "\u2022 Precio original: " + super.getCostoTotal() + "\n" + "\u2022 Precio con descuento: "
				+ this.getCostoTotal();
	}

	@Override
	public int compareTo(final Promocion promocion) {

		int comparacionPrecio = Integer.compare(this.getCostoTotal(), promocion.getCostoTotal());

		if (comparacionPrecio != 0)
			return comparacionPrecio;

		return Double.compare(super.getTiempoTotal(), promocion.getTiempoTotal());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(precioAbsoluto);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromocionAbsoluta other = (PromocionAbsoluta) obj;
		return precioAbsoluto == other.precioAbsoluto;
	}

}
