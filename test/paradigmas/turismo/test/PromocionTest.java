package paradigmas.turismo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import paradigmas.turismo.models.*;
import paradigmas.turismo.resumenUsuario.ResumenUsuario;

public class PromocionTest {

	@Test
	public void calculoPromocionAbsoluta() {

		int costoPromocionEsperada = 600;
		int descuentoAbsoluto = 20;

		List<Atraccion> atraccionesPromObtenida = new ArrayList<Atraccion>();
		atraccionesPromObtenida.add(new Atraccion("Excursión a la cascada", 250, 10, "Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Paseo en carruaje por la ciudad", 120, 5, "Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Excursión al bosque", 250, 5, "Aventura"));
		Promocion promocionObtenida = new PromocionAbsoluta(atraccionesPromObtenida, descuentoAbsoluto);

		assertEquals(costoPromocionEsperada, promocionObtenida.getCostoTotal());
	}

	@Test
	public void calculoPromocionPorcentual() {

		int costoPromocionEsperada = 558;
		Double descuentoPorcentual = 10.0;

		List<Atraccion> atraccionesPromObtenida = new ArrayList<Atraccion>();
		atraccionesPromObtenida.add(new Atraccion("Excursión a la cascada", 250, 10, "Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Paseo en carruaje por la ciudad", 120, 5, "Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Excursión al bosque", 250, 5, "Aventura"));
		Promocion promocionObtenida = new PromocionPorcentual(atraccionesPromObtenida, descuentoPorcentual);

		assertEquals(costoPromocionEsperada, promocionObtenida.getCostoTotal());
	}

	@Test
	public void calculoPromocionAxB() {

		int costoPromocionEsperada = 500;
		Atraccion atraccionGratuita = new Atraccion("Excursión a la cascada", 500, 10, "Aventura");

		List<Atraccion> atraccionesPromObtenida = new ArrayList<Atraccion>();
		atraccionesPromObtenida.add(atraccionGratuita);
		atraccionesPromObtenida.add(new Atraccion("Paseo en carruaje por la ciudad", 200, 5, "Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Excursión al bosque", 300, 5, "Aventura"));

		Promocion promocionObtenida = new PromocionAxB(atraccionesPromObtenida, atraccionGratuita);

		assertEquals(costoPromocionEsperada, promocionObtenida.getCostoTotal());
	}

}
