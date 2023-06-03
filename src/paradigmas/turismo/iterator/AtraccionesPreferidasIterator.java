package paradigmas.turismo.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import paradigmas.turismo.models.Atraccion;
import paradigmas.turismo.models.Promocion;
import paradigmas.turismo.models.Usuario;
import paradigmas.turismo.resumenUsuario.ResumenUsuario;

public class AtraccionesPreferidasIterator implements AtraccionesPreferidasIteratorInterface {

	private Usuario usuario;
	private ResumenUsuario resumenHastaElMomento;
	private List<Atraccion> listaAtracciones;
	private int posicionActual;

	public AtraccionesPreferidasIterator(final List<Atraccion> listaAtracciones, final Usuario usuario,
			final ResumenUsuario resumenHastaElMomento) {

		super();

		this.usuario = usuario;
		this.listaAtracciones = listaAtracciones;
		this.posicionActual = 0;
		this.resumenHastaElMomento = resumenHastaElMomento;

		Collections.sort(this.listaAtracciones);
		Collections.reverse(this.listaAtracciones);
	}

	@Override
	public boolean hasNext() {
		return this.posicionActual < this.listaAtracciones.size();
	}

	@Override
	public Atraccion getNext() {

		if (!this.hasNext())
			return null;

		Atraccion atraccionSugerida = this.listaAtracciones.get(this.posicionActual);

		this.posicionActual++;

		if (this.puedeSerComprada(atraccionSugerida))
			return atraccionSugerida;

		return null;

	}

	@Override
	public void reset() {
		this.posicionActual = 0;
	}

	private boolean puedeSerComprada(final Atraccion atraccion) {
		return (atraccion.getCupo() != 0) && (this.usuario.getTiempoDisponible() >= atraccion.getPromedioDeTiempo())
				&& (this.usuario.getPresupuesto() >= atraccion.getCostoVisita())
				&& !this.yaEstabaEnUnPaqueteComprado(atraccion);
	}

	private boolean yaEstabaEnUnPaqueteComprado(final Atraccion atraccion) {

		List<Promocion> promocionesCompradas = this.resumenHastaElMomento.getPromocionesComparadas();
		boolean estabaComprada = false;

		for (Promocion promocion : promocionesCompradas) {

			List<Atraccion> atraccionesEnLaPromocion = promocion.getAtracciones();

			for (Atraccion atraccionEnLaPromocion : atraccionesEnLaPromocion)
				if (atraccionEnLaPromocion.equals(atraccion))
					estabaComprada = true;
		}

		return estabaComprada;
	}
}
