package paradigmas.turismo.iterator;

import java.util.ArrayList;
import java.util.List;

import paradigmas.turismo.models.Atraccion;
import paradigmas.turismo.models.Promocion;
import paradigmas.turismo.models.Usuario;
import paradigmas.turismo.resumenUsuario.ResumenUsuario;

public class Sugerencia implements SugerenciaInterface {

	private List<Atraccion> listaAtracciones;
	private List<Promocion> listaPromociones;
	private Usuario usuario;
	private ResumenUsuario resumenUsuario;

	public Sugerencia(final List<Atraccion> listaAtracciones, final List<Promocion> listaPromociones,
			final Usuario usuario, final ResumenUsuario resumenUsuario) {

		super();

		this.listaAtracciones = listaAtracciones;
		this.listaPromociones = listaPromociones;
		this.usuario = usuario;
		this.resumenUsuario = resumenUsuario;
	}

	@Override
	public AtraccionesPreferidasIterator crearAtraccionesPreferidasIterator() {

		List<Atraccion> listaAtraccionesDePreferencia = this.getAtraccionesDePreferencia();

		return new AtraccionesPreferidasIterator(listaAtraccionesDePreferencia, this.usuario, this.resumenUsuario);
	}

	private List<Atraccion> getAtraccionesDePreferencia() {

		List<Atraccion> listaAtraccionesDePreferencia = new ArrayList<Atraccion>();
		String atraccionPreferidaUsuario = this.usuario.getAtraccionPreferida();

		for (Atraccion atraccion : this.listaAtracciones) {

			if (atraccion.getTipoAtraccion().compareTo(atraccionPreferidaUsuario) == 0)
				listaAtraccionesDePreferencia.add(atraccion);
		}

		return listaAtraccionesDePreferencia;
	}

	@Override
	public PromocionesPreferidasIteratorInterface crearPromocionesPreferidasIterator() {

		List<Promocion> listaPromocionesDePreferencia = this.getPromocionesDePreferencia();

		return new PromocionesPreferidasIterator(listaPromocionesDePreferencia, this.usuario);
	}

	private List<Promocion> getPromocionesDePreferencia() {

		List<Promocion> listaPromocionesDePreferencia = new ArrayList<Promocion>();

		for (Promocion promocion : this.listaPromociones) {

			if (promocion.getTipoAtracciones().compareTo(this.usuario.getAtraccionPreferida()) == 0)
				listaPromocionesDePreferencia.add(promocion);
		}

		return listaPromocionesDePreferencia;
	}

	@Override
	public AtraccionesNoPreferidasIteratorInterface crearAtraccionesNoPreferidasIterator() {
		
		List<Atraccion> listaAtraccionesDeNoPreferencia = this.getAtraccionesDeNoPreferencia();
		
		return new AtraccionesNoPreferidasIterator(listaAtraccionesDeNoPreferencia, this.usuario, this.resumenUsuario);
		
	}
	
	private List<Atraccion> getAtraccionesDeNoPreferencia() {

		List<Atraccion> listaAtraccionesDeNoPreferencia = new ArrayList<Atraccion>();
		String atraccionPreferidaUsuario = this.usuario.getAtraccionPreferida();

		for (Atraccion atraccion : this.listaAtracciones) {

			if (atraccion.getTipoAtraccion().compareTo(atraccionPreferidaUsuario) != 0)
				listaAtraccionesDeNoPreferencia.add(atraccion);
		}

		return listaAtraccionesDeNoPreferencia;
	}


	@Override
	public PromocionesNoPreferidasIteratorInterface crearPromocionesNoPreferidasIterator() {
		
		List<Promocion> listaPromocionesDeNoPreferencia = this.getPromocionesDeNoPreferencia();

		return new PromocionesNoPreferidasIterator(listaPromocionesDeNoPreferencia, this.usuario);
	}
	

	private List<Promocion> getPromocionesDeNoPreferencia() {

		List<Promocion> listaPromocionesDeNoPreferencia = new ArrayList<Promocion>();
		String atraccionPreferida = this.usuario.getAtraccionPreferida();

		for (Promocion promocion : this.listaPromociones) {

			if (promocion.getTipoAtracciones().compareTo(atraccionPreferida) != 0)
				listaPromocionesDeNoPreferencia.add(promocion);
		}

		return listaPromocionesDeNoPreferencia;
	}

}
