package paradigmas.turismo.iterator;

import java.util.Collections;
import java.util.List;

import paradigmas.turismo.models.Promocion;
import paradigmas.turismo.models.Usuario;

public class PromocionesPreferidasIterator implements PromocionesIteratorInterface {

	private Usuario usuario;
	private List<Promocion> listaPromociones;
	private int posicionActual;

	public PromocionesPreferidasIterator(final List<Promocion> listaPromociones, final Usuario usuario) {

		super();

		this.usuario = usuario;
		this.listaPromociones = listaPromociones;
		this.posicionActual = 0;

		Collections.sort(this.listaPromociones);
		Collections.reverse(this.listaPromociones);
	}

	@Override
	public boolean hasNext() {
		return this.posicionActual < this.listaPromociones.size();
	}

	@Override
	public Promocion getNext() {

		if (!this.hasNext())
			return null;

		Promocion promocionSugerida = this.listaPromociones.get(this.posicionActual);
		this.posicionActual++;

		if (this.puedeComprarse(promocionSugerida))
			return promocionSugerida;

		return null;
	}

	@Override
	public void reset() {
		this.posicionActual = 0;
	}

	private boolean puedeComprarse(final Promocion promocion) {
		return (promocion.hayCupo()) && (this.usuario.getTiempoDisponible() >= promocion.getTiempoTotal())
				&& (this.usuario.getPresupuesto() >= promocion.getCostoTotal());
	}
}
