package paradigmas.turismo.iterator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import paradigmas.turismo.models.Promocion;
import paradigmas.turismo.models.Usuario;

public class PromocionesIterator implements PromocionesIteratorInterface {

	private Usuario usuario;
	private List<Promocion> listaPromociones;
	private int posicionActual;

	public PromocionesIterator(final List<Promocion> listaPromociones, final Usuario usuario) {

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

	private boolean puedeComprarse(final Promocion promocion) {
		return (this.usuario.getTiempoDisponible() >= promocion.getTiempoTotal())
				&& (this.usuario.getPresupuesto() >= promocion.getCostoTotal());
	}

	public List<Promocion> getPromocionesCollection() {
		return Collections.unmodifiableList(this.listaPromociones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PromocionesIterator other = (PromocionesIterator) obj;
		return Objects.equals(listaPromociones, other.listaPromociones) && posicionActual == other.posicionActual
				&& Objects.equals(usuario, other.usuario);
	}
}
