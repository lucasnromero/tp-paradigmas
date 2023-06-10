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
		return super.toString() + "-Duracion: " + super.getTiempoTotal() + "\n" 
								+ "-Precio original: " + super.getCostoTotal() + "\n"
								+ "-Precio promocional: " + this.getCostoTotal()
								+ "¡La atracción " + this.getAtraccionGratuita().getNombreAtraccion() + " es gratis!";
	}

	@Override
	public String toStringUI() {
		return super.toStringUI() + "\u2022 Duración: " + super.getTiempoTotal() +" horas"+ "\n" 
									+ "\u2022 Precio original: " + super.getCostoTotal() + "\n"
									+ "\u2022 Precio promocional: " + this.getCostoTotal()+ "\n"
									+ "¡La atracción " + this.getAtraccionGratuita().getNombreAtraccion() + " es gratis!";
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

}
