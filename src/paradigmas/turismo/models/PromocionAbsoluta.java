package paradigmas.turismo.models;

import java.util.List;

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
