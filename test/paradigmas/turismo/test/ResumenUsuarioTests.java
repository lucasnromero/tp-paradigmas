package paradigmas.turismo.test;

import paradigmas.turismo.models.*;
import paradigmas.turismo.resumenUsuario.ResumenUsuario;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ResumenUsuarioTests {

	@Test
	public void calcularCostoTotalTest() {

		Usuario usuario = new Usuario("Usuario 1", 40.5, 5000, "Aventura");
		List<Atraccion> atraccionesPromocion = new ArrayList<>();

		ResumenUsuario resumen = new ResumenUsuario(usuario);

		resumen.agregarAtraccion(new Atraccion("Torre del Sabor", 150, 2.5, 50, "Degustación"));
		resumen.agregarAtraccion(new Atraccion("Mirador de Ensueño", 200, 3.0, 40, "Paisaje"));
		resumen.agregarAtraccion(new Atraccion("Ruta de los Sabores", 180, 2.0, 30, "Degustación"));
		resumen.agregarAtraccion(new Atraccion("Aventura Extrema", 120, 1.5, 20, "Aventura"));
		resumen.agregarAtraccion(new Atraccion("Valle Encantado", 160, 2.5, 35, "Paisaje"));

		atraccionesPromocion.add(new Atraccion("La Torre de los Vengadores", 150, 2.5, 50, "Aventura"));
		atraccionesPromocion.add(new Atraccion("El Horizonte de Asgard", 200, 3.0, 40, "Aventura"));
		atraccionesPromocion.add(new Atraccion("El Sendero de Wakanda", 180, 2.0, 30, "Aventura"));

		Promocion promocion = new PromocionAbsoluta(atraccionesPromocion, 100);

		resumen.agregarPromocion(promocion);

		resumen.crearResumenUsuario();

		int costoEsperado = 1240;

		assertEquals(costoEsperado, resumen.getGastoTotal(), 0.01);

	}

	@Test
	public void calcularTiempoTotalTest() {

		Usuario usuario = new Usuario("Usuario 1", 40.5, 5000, "Aventura");
		List<Atraccion> atraccionesPromocion = new ArrayList<>();

		ResumenUsuario resumen = new ResumenUsuario(usuario);

		resumen.agregarAtraccion(new Atraccion("Torre del Sabor", 150, 2.5, 50, "Degustación"));
		resumen.agregarAtraccion(new Atraccion("Mirador de Ensueño", 200, 3.0, 40, "Paisaje"));
		resumen.agregarAtraccion(new Atraccion("Ruta de los Sabores", 180, 2.0, 30, "Degustación"));
		resumen.agregarAtraccion(new Atraccion("Aventura Extrema", 120, 1.5, 20, "Aventura"));
		resumen.agregarAtraccion(new Atraccion("Valle Encantado", 160, 2.5, 35, "Paisaje"));

		atraccionesPromocion.add(new Atraccion("La Torre de los Vengadores", 150, 2.5, 50, "Aventura"));
		atraccionesPromocion.add(new Atraccion("El Horizonte de Asgard", 200, 3.0, 40, "Aventura"));
		atraccionesPromocion.add(new Atraccion("El Sendero de Wakanda", 180, 2.0, 30, "Aventura"));

		Promocion promocion = new PromocionAbsoluta(atraccionesPromocion, 100);

		resumen.agregarPromocion(promocion);
		resumen.crearResumenUsuario();

		double tiempoEsperado = 19.0;

		assertEquals(tiempoEsperado, resumen.getTiempoTotal(), 0.01);

	}

	@Test
	public void agregarPromocionTest() {
		Usuario usuario = new Usuario("Tony Stark", 35.2, 500, "Paisaje");
		List<Atraccion> atraccionesPromocion = new ArrayList<>();
		ResumenUsuario resumen = new ResumenUsuario(usuario);
		Atraccion gratuita = new Atraccion("El Sendero de Wakanda", 180, 2.0, 30, "Aventura");

		atraccionesPromocion.add(new Atraccion("La Torre de los Vengadores", 150, 2.5, 50, "Aventura"));
		atraccionesPromocion.add(new Atraccion("El Horizonte de Asgard", 200, 3.0, 40, "Aventura"));
		atraccionesPromocion.add(gratuita);

		resumen.agregarPromocion(new PromocionAxB(atraccionesPromocion, gratuita));

		resumen.crearResumenUsuario();

		double tiempoEsperado = 7.5;
		int gastoEsperado = 350;

		assertEquals(tiempoEsperado, resumen.getTiempoTotal(), 0.01);
		assertEquals(gastoEsperado, resumen.getGastoTotal(), 0.01);

	}

	@Test
	public void agregarAtraccionTest() {
		Usuario usuario = new Usuario("Clint Barton", 35.2, 200, "Paisaje");

		ResumenUsuario resumen = new ResumenUsuario(usuario);

		resumen.agregarAtraccion(new Atraccion("Paseo en bote", 150, 3.0, 40, "Paisaje"));

		resumen.crearResumenUsuario();

		double tiempoEsperado = 3.0;
		int gastoEsperado = 150;

		assertEquals(tiempoEsperado, resumen.getTiempoTotal(), 0.01);
		assertEquals(gastoEsperado, resumen.getGastoTotal(), 0.01);

	}

	@Test
	public void getUsuarioTest() {
		Usuario usuario = new Usuario("Steve Rogers", 120.3, 200, "Aventura");

		ResumenUsuario resumen = new ResumenUsuario(usuario);

		assertEquals(usuario, resumen.getUsuario());
	}

	@Test
	public void getAtracccionesCompradasTest() {
		Usuario usuario = new Usuario("Stephen Strange", 5.5, 300, "Paisaje");
		List<Atraccion> atracciones = new ArrayList<>();

		atracciones.add(new Atraccion("La Torre de los Vengadores", 150, 2.5, 50, "Degustación"));
		atracciones.add(new Atraccion("El Horizonte de Asgard", 200, 3.0, 40, "Paisaje"));
		atracciones.add(new Atraccion("El Sendero de Wakanda", 180, 2.0, 30, "Degustación"));
		atracciones.add(new Atraccion("La Aventura de Wakanda", 120, 1.5, 20, "Aventura"));
		atracciones.add(new Atraccion("El Jardín de la Galaxia", 160, 2.8, 35, "Paisaje"));

		ResumenUsuario resumen = new ResumenUsuario(usuario);

		for (Atraccion a : atracciones)
			resumen.agregarAtraccion(a);

		assertEquals(atracciones, resumen.getAtraccionesCompradas());
	}

	@Test
	public void getPromocionesCompradasTest() {
		Usuario usuario = new Usuario("Steve Rogers", 120.3, 1000, "Aventura");
		List<Atraccion> atraccionesAxB = new ArrayList<>();
		List<Atraccion> atraccionesAbsolutas = new ArrayList<>();

		ResumenUsuario resumen = new ResumenUsuario(usuario);
		Atraccion gratuita = new Atraccion("El Sendero de Wakanda", 180, 2.0, 30, "Aventura");

		atraccionesAxB.add(new Atraccion("La Torre de los Vengadores", 150, 2.5, 50, "Aventura"));
		atraccionesAxB.add(new Atraccion("El Horizonte de Asgard", 200, 3.0, 40, "Aventura"));
		atraccionesAxB.add(gratuita);

		atraccionesAbsolutas.add(new Atraccion("Mirador Asgardiano", 200, 0.5, 15, "Paisaje"));
		atraccionesAbsolutas.add(new Atraccion("Valle Encantado ", 50, 1.0, 30, "Paisaje"));
		atraccionesAbsolutas.add(new Atraccion("Rincón de Maravillas", 130, 4.5, 12, "Paisaje"));

		Promocion absoluta = new PromocionAbsoluta(atraccionesAbsolutas, 70);
		Promocion axb = new PromocionAxB(atraccionesAxB, gratuita);

		resumen.agregarPromocion(absoluta);
		resumen.agregarPromocion(axb);

		List<Promocion> promocionesEsperadas = new ArrayList<Promocion>();

		promocionesEsperadas.add(absoluta);
		promocionesEsperadas.add(axb);

		assertEquals(promocionesEsperadas, resumen.getPromocionesCompradas());
	}

}