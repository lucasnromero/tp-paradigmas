package paradigmas.turismo.test;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import paradigmas.turismo.iterator.AtraccionesIteratorInterface;
import paradigmas.turismo.iterator.PromocionesIteratorInterface;
import paradigmas.turismo.iterator.Sugerencia;
import paradigmas.turismo.iterator.SugerenciaInterface;
import paradigmas.turismo.manejoArchivos.Archivo;
import paradigmas.turismo.models.Atraccion;
import paradigmas.turismo.models.Promocion;
import paradigmas.turismo.models.PromocionAbsoluta;
import paradigmas.turismo.models.PromocionPorcentual;
import paradigmas.turismo.models.Usuario;
import paradigmas.turismo.resumenUsuario.ResumenUsuario;

public class OfertasTest {

	private List<Atraccion> listaAtracciones;
	private List<Promocion> listaPromociones;
	private List<Usuario> listaUsuarios;

	@Before
	public void setup() {

		Archivo archivoAtracciones = new Archivo("atracciones");
		Archivo archivoPromociones = new Archivo("promociones");
		Archivo archivoUsuarios = new Archivo("usuarios");

		this.listaAtracciones = archivoAtracciones.leerArchivoAtracciones();
		this.listaPromociones = archivoPromociones.leerArchivoPromociones(this.listaAtracciones);
		this.listaUsuarios = archivoUsuarios.leerArchivoUsuarios();
	}

	/*
	 * ¿Se esta ofertando correctamente?
	 */

	@Test
	public void ofertadorTest() {

		for (Usuario usuario : this.listaUsuarios) {

			ResumenUsuario resumenUsuario = new ResumenUsuario(usuario);

			SugerenciaInterface sugerencia = new Sugerencia(this.listaAtracciones, this.listaPromociones, usuario,
					resumenUsuario);

			PromocionesIteratorInterface promocionesPreferidasIterator = sugerencia
					.crearPromocionesPreferidasIterator();
			AtraccionesIteratorInterface atraccionesPreferidasIterator = sugerencia
					.crearAtraccionesPreferidasIterator();
			PromocionesIteratorInterface promocionesNoPreferidasIterator = sugerencia
					.crearPromocionesNoPreferidasIterator();
			AtraccionesIteratorInterface atraccionesNoPreferidasIterator = sugerencia
					.crearAtraccionesNoPreferidasIterator();

			this.preferenciaTest(promocionesPreferidasIterator, atraccionesPreferidasIterator,
					promocionesNoPreferidasIterator, atraccionesNoPreferidasIterator, usuario);
		}
	}

	private void preferenciaTest(final PromocionesIteratorInterface promocionesPreferidasIterator,
			final AtraccionesIteratorInterface atraccionesPreferidasIterator,
			final PromocionesIteratorInterface promocionesNoPreferidasIterator,
			final AtraccionesIteratorInterface atraccionesNoPreferidasIterator, final Usuario usuario) {

		Assert.assertTrue(this.sonAtraccionesPreferidas(atraccionesPreferidasIterator, usuario));
		Assert.assertTrue(this.sonPromocionesPreferidas(promocionesPreferidasIterator, usuario));

		Assert.assertFalse(this.sonAtraccionesPreferidas(atraccionesNoPreferidasIterator, usuario));
		Assert.assertFalse(this.sonPromocionesPreferidas(promocionesNoPreferidasIterator, usuario));
	}

	private boolean sonAtraccionesPreferidas(final AtraccionesIteratorInterface atraccionesIterator,
			final Usuario usuario) {

		int atraccionesNoPreferidas = 0;
		String atraccionPreferidaUsuario = usuario.getAtraccionPreferida();

		List<Atraccion> listaAtraccionesDelIterador = atraccionesIterator.getAtraccionesCollection();

		for (Atraccion atraccion : listaAtraccionesDelIterador) {

			String tipoAtraccion = atraccion.getTipoAtraccion();

			if (atraccionPreferidaUsuario.compareTo(tipoAtraccion) != 0)
				atraccionesNoPreferidas++;

		}

		boolean sonTodasPreferidas = true;

		if (atraccionesNoPreferidas > 0)
			sonTodasPreferidas = false;

		return sonTodasPreferidas;
	}

	private boolean sonPromocionesPreferidas(final PromocionesIteratorInterface promocionesIterator,
			final Usuario usuario) {

		int promocionesNoPreferidas = 0;
		String atraccionPreferidaUsuario = usuario.getAtraccionPreferida();

		List<Promocion> listaPromocionesDelIterador = promocionesIterator.getPromocionesCollection();

		for (Promocion promocion : listaPromocionesDelIterador) {

			String tipoPromocion = promocion.getTipoAtracciones();

			if (atraccionPreferidaUsuario.compareTo(tipoPromocion) != 0)
				promocionesNoPreferidas++;

		}

		boolean sonTodasPreferidas = true;

		if (promocionesNoPreferidas > 0)
			sonTodasPreferidas = false;

		return sonTodasPreferidas;
	}

	@Test
	public void ordenTest() {

		Usuario usuario = new Usuario("Iron man", 100, 1000, "Aventura");

		ResumenUsuario resumenUsuario = new ResumenUsuario(usuario);

		SugerenciaInterface sugerencia = new Sugerencia(this.listaAtracciones, this.listaPromociones, usuario,
				resumenUsuario);

		PromocionesIteratorInterface promocionesPreferidasIterator = sugerencia.crearPromocionesPreferidasIterator();
		AtraccionesIteratorInterface atraccionesPreferidasIterator = sugerencia.crearAtraccionesPreferidasIterator();

		this.ordenPromocionesTest(promocionesPreferidasIterator);
		this.ordenAtraccionesTest(atraccionesPreferidasIterator);

	}

	private void ordenPromocionesTest(final PromocionesIteratorInterface promocionesPreferidasIterator) {

		List<Atraccion> listaAtraccionesPromocion1 = Arrays.asList(
				new Atraccion("El Reino de Wakanda", 200, 8, 3, "Aventura"),
				new Atraccion("El Laboratorio del Dr. Strange", 220, 9, 2, "Aventura"),
				new Atraccion("La Fortaleza de Loki", 15, 9, 10, "Aventura"));

		List<Atraccion> listaAtraccionesPromocion2 = Arrays.asList(new Atraccion("Wakanda", 200, 5, 10, "Aventura"),
				new Atraccion("El Cañón del Capitán América", 170, 6, 20, "Aventura"),
				new Atraccion("La Cueva de Black Widow", 90, 2, 3, "Aventura"));

		Promocion promocion1 = new PromocionAbsoluta(listaAtraccionesPromocion1, 50);
		Promocion promocion2 = new PromocionPorcentual(listaAtraccionesPromocion2, 30);

		List<Promocion> listaPromocionesEsperada = Arrays.asList(promocion1, promocion2);

		List<Promocion> listaPromocionesResultante = promocionesPreferidasIterator.getPromocionesCollection();

		Assert.assertEquals(listaPromocionesEsperada, listaPromocionesResultante);

	}

	private void ordenAtraccionesTest(final AtraccionesIteratorInterface atraccionesPreferidasIterator) {

		Atraccion atraccion1 = new Atraccion("El Laboratorio del Dr. Strange", 220, 9, 3, "Aventura");
		Atraccion atraccion2 = new Atraccion("El Reino de Wakanda", 200, 8, 4, "Aventura");
		Atraccion atraccion3 = new Atraccion("Wakanda", 200, 5, 10, "Aventura");
		Atraccion atraccion4 = new Atraccion("El Cañón del Capitán América", 170, 6, 30, "Aventura");
		Atraccion atraccion5 = new Atraccion("La Cueva de Black Widow", 90, 2, 5, "Aventura");
		Atraccion atraccion6 = new Atraccion("La Fortaleza de Loki", 15, 9, 8, "Aventura");

		List<Atraccion> listaAtraccionesEsperada = Arrays.asList(atraccion1, atraccion2, atraccion3, atraccion4,
				atraccion5, atraccion6);

		List<Atraccion> listaAtraccionesResultante = atraccionesPreferidasIterator.getAtraccionesCollection();

		Assert.assertEquals(listaAtraccionesEsperada, listaAtraccionesResultante);
	}
}
