package paradigmas.turismo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import paradigmas.turismo.models.*;
import paradigmas.turismo.resumenUsuario.ResumenUsuario;

public class PromocionTest {

	@Test
	public void descuentoCupo() {
		
		List <Atraccion> atraccionesPromEsperada = new ArrayList<Atraccion>();
		atraccionesPromEsperada.add(new Atraccion("Excursión a la cascada",250,2.5,20,"Aventura"));
		atraccionesPromEsperada.add(new Atraccion("Paseo en carruaje por la ciudad",120,1.0,30,"Aventura"));
		atraccionesPromEsperada.add(new Atraccion("Excursión al bosque",250,2.5,15,"Aventura"));
		Promocion promocionEsperada = new PromocionAbsoluta(atraccionesPromEsperada, 20);
		
		List <Atraccion> atraccionesPromObtenida = new ArrayList<Atraccion>();
		atraccionesPromObtenida.add(new Atraccion("Excursión a la cascada",250,2.5,21,"Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Paseo en carruaje por la ciudad",120,1.0,31,"Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Excursión al bosque",250,2.5,16,"Aventura"));
		Promocion promocionObtenida = new PromocionAbsoluta(atraccionesPromObtenida, 20);
		
		promocionObtenida.reducirCupo();
		
		assertEquals(promocionEsperada, promocionObtenida);
	}
	
	@Test
	public void calculoPromocionAbsoluta() {
		
		int costoPromocionEsperada = 600;
		int descuentoAbsoluto = 20;
		
		List <Atraccion> atraccionesPromObtenida = new ArrayList<Atraccion>();
		atraccionesPromObtenida.add(new Atraccion("Excursión a la cascada",250,10,21,"Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Paseo en carruaje por la ciudad",120,5,31,"Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Excursión al bosque",250,5,16,"Aventura"));
		Promocion promocionObtenida = new PromocionAbsoluta(atraccionesPromObtenida, descuentoAbsoluto);
		
		assertEquals(costoPromocionEsperada, promocionObtenida.getCostoTotal());
	}
	
	@Test
	public void calculoPromocionPorcentual() {
		
		int costoPromocionEsperada = 558;
		Double descuentoPorcentual = 10.0;
		
		List <Atraccion> atraccionesPromObtenida = new ArrayList<Atraccion>();
		atraccionesPromObtenida.add(new Atraccion("Excursión a la cascada",250,10,21,"Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Paseo en carruaje por la ciudad",120,5,31,"Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Excursión al bosque",250,5,16,"Aventura"));
		Promocion promocionObtenida = new PromocionPorcentual(atraccionesPromObtenida, descuentoPorcentual);
		
		assertEquals(costoPromocionEsperada, promocionObtenida.getCostoTotal());
	}
	
	@Test
	public void calculoPromocionAxB() {
		
		int costoPromocionEsperada = 500;
		Atraccion atraccionGratuita = new Atraccion("Excursión a la cascada",500,10,21,"Aventura");
		
		List <Atraccion> atraccionesPromObtenida = new ArrayList<Atraccion>();
		atraccionesPromObtenida.add(atraccionGratuita);
		atraccionesPromObtenida.add(new Atraccion("Paseo en carruaje por la ciudad",200,5,31,"Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Excursión al bosque",300,5,16,"Aventura"));
		
		Promocion promocionObtenida = new PromocionAxB(atraccionesPromObtenida, atraccionGratuita);
		
		assertEquals(costoPromocionEsperada, promocionObtenida.getCostoTotal());
	}
	
	@Test
	public void comprarPromocionCupoTest() {
		Usuario usuario = new Usuario("Tony Stark", 35.2, 500, "Paisaje");
		
		List<Atraccion> atraccionesPromocion = new ArrayList<>();
		ResumenUsuario resumen = new ResumenUsuario(usuario);
		
		Atraccion gratuita = new Atraccion("El Sendero de Wakanda", 180, 2.0, 30, "Aventura");

		atraccionesPromocion.add(new Atraccion("La Torre de los Vengadores", 150, 2.5, 50, "Aventura"));
		atraccionesPromocion.add(new Atraccion("El Horizonte de Asgard", 200, 3.0, 40, "Aventura"));
		atraccionesPromocion.add(gratuita);
		
		int valorEsperado = atraccionesPromocion.get(2).getCupo();
	
		resumen.agregarPromocion(new PromocionAxB(atraccionesPromocion, gratuita));
		
		assertEquals(valorEsperado - 1, atraccionesPromocion.get(2).getCupo());
	}
	
	
	

}
